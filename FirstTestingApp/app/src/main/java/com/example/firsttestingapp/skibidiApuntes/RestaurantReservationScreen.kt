package com.example.myapplication

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Calendar
import java.util.Locale

// Modelo de datos para guardar la reserva
data class ReservationItem(
    val id: String,
    val clientName: String,
    val phone: String,
    val guestsCount: Int,
    val date: String,
    val timeSlot: String,
    val zone: String,
    val specialNotes: String
)

@Composable
fun RestaurantReservationScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // Estados del formulario
    var clientName by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var guestsCount by rememberSaveable { mutableIntStateOf(2) }
    var selectedDate by rememberSaveable { mutableStateOf("") }
    var selectedTimeSlot by rememberSaveable { mutableStateOf("") }
    var selectedZone by rememberSaveable { mutableStateOf("Interior") }
    var specialNotes by rememberSaveable { mutableStateOf("") }

    // Validación y diálogos
    var nameError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var dateError by remember { mutableStateOf(false) }
    var timeError by remember { mutableStateOf(false) }

    var confirmedReservation by remember { mutableStateOf<ReservationItem?>(null) }
    val reservationsList = remember { mutableStateListOf<ReservationItem>() }

    // Opciones de horarios y zonas del restaurante
    val timeSlots = listOf("13:30", "14:00", "14:30", "15:00", "20:30", "21:00", "21:30", "22:00")
    val zones = listOf("Interior", "Terraza", "Zona VIP")

    // DatePickerDialog de Android
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            selectedDate = String.format(Locale.getDefault(), "%02d/%02d/%d", selectedDayOfMonth, selectedMonth + 1, selectedYear)
            dateError = false
        },
        year,
        month,
        day
    ).apply {
        // No permitir seleccionar fechas pasadas
        datePicker.minDate = System.currentTimeMillis() - 1000
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // --- 1. Cabecera del restaurante ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "🍽️",
                        fontSize = 30.sp
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Restaurante La Salsita de fabio",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Text(
                        text = "Reserva tu mesa en segundos",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 4.dp)
                    ) {
                        Text(
                            text = "⭐ 4.8 (250+ valoraciones)",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }

        // --- 2. Formulario de Reserva ---
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Datos de la Reserva",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                // Nombre completo
                OutlinedTextField(
                    value = clientName,
                    onValueChange = {
                        clientName = it
                        nameError = false
                    },
                    label = { Text("Nombre Completo") },
                    leadingIcon = { Text("👤", fontSize = 18.sp) },
                    isError = nameError,
                    supportingText = {
                        if (nameError) {
                            Text("Por favor, introduce tu nombre", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Teléfono de contacto
                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
                        phoneError = false
                    },
                    label = { Text("Teléfono de Contacto") },
                    leadingIcon = { Text("📞", fontSize = 18.sp) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    isError = phoneError,
                    supportingText = {
                        if (phoneError) {
                            Text("Por favor, introduce un teléfono", color = MaterialTheme.colorScheme.error)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                // Número de personas
                Text(
                    text = "Número de Personas",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "$guestsCount ${if (guestsCount == 1) "persona" else "personas"}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedButton(
                            onClick = { if (guestsCount > 1) guestsCount-- },
                            enabled = guestsCount > 1
                        ) {
                            Text("-", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "$guestsCount",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        OutlinedButton(
                            onClick = { if (guestsCount < 12) guestsCount++ },
                            enabled = guestsCount < 12
                        ) {
                            Text("+", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

                // Selección de fecha
                Text(
                    text = "Fecha de Reserva",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                OutlinedButton(
                    onClick = { datePickerDialog.show() },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = if (selectedDate.isEmpty()) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("📅", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = if (selectedDate.isEmpty()) "Seleccionar Fecha" else "Fecha: $selectedDate",
                        fontWeight = FontWeight.Medium
                    )
                }
                if (dateError) {
                    Text(
                        text = "Por favor, selecciona una fecha",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                // Selección de Hora (Chips)
                Text(
                    text = "Hora de Reserva",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    timeSlots.forEach { slot ->
                        FilterChip(
                            selected = selectedTimeSlot == slot,
                            onClick = {
                                selectedTimeSlot = slot
                                timeError = false
                            },
                            label = { Text(slot) }
                        )
                    }
                }
                if (timeError) {
                    Text(
                        text = "Por favor, selecciona una hora",
                        color = MaterialTheme.colorScheme.error,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                // Selección de Zona del restaurante
                Text(
                    text = "Zona Preferida",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    zones.forEach { zone ->
                        FilterChip(
                            selected = selectedZone == zone,
                            onClick = { selectedZone = zone },
                            label = { Text(zone) }
                        )
                    }
                }

                // Notas especiales
                OutlinedTextField(
                    value = specialNotes,
                    onValueChange = { specialNotes = it },
                    label = { Text("Notas especiales / Alergias (Opcional)") },
                    leadingIcon = { Text("📝", fontSize = 18.sp) },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 3
                )

                // Botón de Confirmación
                Button(
                    onClick = {
                        // Validar campos requeridos
                        nameError = clientName.isBlank()
                        phoneError = phone.isBlank()
                        dateError = selectedDate.isEmpty()
                        timeError = selectedTimeSlot.isEmpty()

                        if (!nameError && !phoneError && !dateError && !timeError) {
                            val newReservation = ReservationItem(
                                id = "RES-${(1000..9999).random()}",
                                clientName = clientName.trim(),
                                phone = phone.trim(),
                                guestsCount = guestsCount,
                                date = selectedDate,
                                timeSlot = selectedTimeSlot,
                                zone = selectedZone,
                                specialNotes = specialNotes.trim()
                            )
                            reservationsList.add(0, newReservation)
                            confirmedReservation = newReservation

                            // Limpiar formulario tras reservar
                            clientName = ""
                            phone = ""
                            guestsCount = 2
                            selectedDate = ""
                            selectedTimeSlot = ""
                            selectedZone = "Interior"
                            specialNotes = ""
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Confirmar Reserva",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // --- 3. Lista de reservas activas ---
        if (reservationsList.isNotEmpty()) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Tus Reservas (${reservationsList.size})",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                reservationsList.forEach { reservation ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = reservation.clientName,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )
                                Text(
                                    text = "📅 ${reservation.date} a las ⏰ ${reservation.timeSlot}",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                                Text(
                                    text = "👥 ${reservation.guestsCount} personas | 📍 Zona: ${reservation.zone}",
                                    fontSize = 13.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                if (reservation.specialNotes.isNotEmpty()) {
                                    Text(
                                        text = "📝 ${reservation.specialNotes}",
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f)
                                    )
                                }
                                Text(
                                    text = "Código: ${reservation.id}",
                                    fontSize = 11.sp,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 4.dp)
                                )
                            }

                            IconButton(
                                onClick = { reservationsList.remove(reservation) }
                            ) {
                                Text("🗑️", fontSize = 18.sp)
                            }
                        }
                    }
                }
            }
        }
    }

    // --- 4. Diálogo modal de confirmación ---
    confirmedReservation?.let { reservation ->
        AlertDialog(
            onDismissRequest = { confirmedReservation = null },
            icon = {
                Text("✅", fontSize = 40.sp)
            },
            title = {
                Text(
                    text = "¡Reserva Confirmada!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Tu mesa ha sido reservada con éxito.")
                    Text(text = "👤 Nombre: ${reservation.clientName}")
                    Text(text = "📅 Fecha: ${reservation.date}")
                    Text(text = "⏰ Hora: ${reservation.timeSlot}")
                    Text(text = "👥 Personas: ${reservation.guestsCount}")
                    Text(text = "📍 Zona: ${reservation.zone}")
                    Text(
                        text = "Código de reserva: ${reservation.id}",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = { confirmedReservation = null }) {
                    Text("Aceptar")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantReservationScreenPreview() {
    MyApplicationTheme {
        RestaurantReservationScreen()
    }
}
