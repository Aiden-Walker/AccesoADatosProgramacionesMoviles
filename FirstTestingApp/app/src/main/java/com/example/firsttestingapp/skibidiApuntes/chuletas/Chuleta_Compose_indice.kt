// =====================================================================
//  CHULETA KOTLIN + JETPACK COMPOSE (Material 3)
//  Cada bloque está dentro de /* ... */ para que el archivo no
//  rompa al compilar. Copia lo que necesites.
//  Índice:
//   0. Imports habituales
//   1. Kotlin básico
//   2. MainActivity + Scaffold
//   3. Modifier (todas las funciones útiles)
//   4. Layouts (Box, Column, Row, Spacer, listas, Card)
//   5. Text
//   6. TextField / OutlinedTextField
//   7. Botones
//   8. Checkbox, Switch, Radio, Slider, Desplegable, Dialog
//   9. Estado, recomposición y State Hoisting
//  10. Snackbar
//  11. Image, Icon, ProgressIndicator, TopAppBar, FAB
//  12. ESTRUCTURAS COMPLEJAS (patrones de examen)
//  13. Errores típicos / checklist
// =====================================================================


// =====================================================================
//  ÍNDICE DETALLADO (qué incluye cada sección, sin código)
//  CÓMO BUSCAR: Ctrl+F y escribe la palabra (ej. "desplegable",
//  "campo de texto", "snackbar", "contador"). Cada bloque lleva una
//  línea "ETIQUETAS:" con sinónimos para que lo encuentres aunque no
//  recuerdes el nombre exacto. Ctrl+F "ETIQUETAS" recorre todos.
// =====================================================================
//
//  0. IMPORTS HABITUALES
//     - Lista de imports más usados (foundation, layout, material3, runtime, ui)
//     - Los dos imports obligatorios para usar 'by' (getValue / setValue)
//
//  1. KOTLIN BÁSICO
//     - Variables: val / var, tipo explícito e inferido
//     - Null safety: tipos nullables, llamada segura, Elvis, let, !!
//     - String templates ($variable y ${expresión})
//     - Funciones: expresión, parámetros por defecto y nombrados, recibir lambdas
//     - Condiciones: if como expresión, operadores lógicos, rangos, comprobaciones de String
//     - when: con argumento, con rangos y tipos, sin argumento
//     - Bucles: for, until, downTo, step, withIndex, repeat, while
//     - Colecciones: listas de solo lectura y mutables, mapas, filter, map, sum, any, all...
//     - Funciones útiles de String y Char (solo dígitos, filter, take, replace...)
//     - Clases: data class, copy, desestructuración, enum, funciones de extensión
//     - Lambdas: sintaxis, 'it', trailing lambda, tipos más habituales
//
//  2. MAINACTIVITY + SCAFFOLD
//     - Estructura de MainActivity (onCreate, setContent, tema, Scaffold, innerPadding)
//     - Todas las ranuras del Scaffold (topBar, bottomBar, FAB, snackbarHost...)
//     - @Preview y sus parámetros
//
//  3. MODIFIER
//     - Regla de oro modifier (minúscula) vs Modifier (mayúscula)
//     - Tamaño (fillMax..., size, width, height, límites, aspectRatio)
//     - Reparto con weight
//     - Padding y margen (orden respecto al fondo)
//     - Fondo, borde, recorte, sombra, transparencia
//     - Interacción: clickable y scroll
//     - Posición de un hijo: align, offset
//     - Formas (esquinas fijas, porcentaje, círculo)
//     - Colores (predefinidos, hexadecimal, alpha, colores del tema)
//
//  4. LAYOUTS
//     - Column, Row y Box con todos sus parámetros de alineación
//     - Arrangement y Alignment: valores disponibles
//     - Spacer (fijo y flexible)
//     - Card y Surface
//     - Separador (Divider)
//     - LazyColumn / LazyRow (listas con scroll propio)
//     - Cómo repartir elementos en una Row (weight vs SpaceEvenly)
//
//  5. TEXT
//     - Todos los parámetros de Text (color, tamaño, estilo, grosor, espaciado,
//       decoración, alineación, líneas máximas, desbordamiento, estilo del tema)
//     - Texto como enlace, texto condicional y texto según estado
//
//  6. TEXTFIELD / OUTLINEDTEXTFIELD
//     - Todos los parámetros (value, label, placeholder, iconos, error, teclado,
//       acciones del teclado, transformación visual, forma, colores)
//     - Variantes: TextField, OutlinedTextField, BasicTextField
//     - Filtros de entrada en onValueChange (dígitos, longitud, mayúsculas...)
//     - Validaciones típicas (teléfono, email, PIN, formulario completo)
//     - Campo de contraseña con mostrar/ocultar
//
//  7. BOTONES
//     - Tipos y jerarquía: Button, FilledTonal, Elevated, Outlined, TextButton
//     - Todos los parámetros de Button y sus valores de ejemplo
//     - Colores y elevación de cada variante
//     - Botón con icono + texto e IconButton
//     - Botones + / - con límites (deshabilitar en mínimo y máximo, coerceIn)
//
//  8. OTROS CONTROLES
//     - Checkbox, Switch, RadioButton (grupo), Slider
//     - Desplegable clásico (DropdownMenu) y desplegable de formulario
//       (ExposedDropdownMenuBox)
//     - AlertDialog (diálogo de confirmación)
//
//  9. ESTADO, RECOMPOSICIÓN Y STATE HOISTING
//     - Por qué fallan var normal y mutableStateOf sin remember
//     - remember vs rememberSaveable (y rotación de pantalla)
//     - Delegación con 'by' y uso de .value
//     - Tipos de estado (Int, Long, Float, Double, String, Boolean)
//     - Estado derivado (derivedStateOf) y variables calculadas
//     - Listas con estado (mutableStateListOf)
//     - State Hoisting: padre con estado, hijos stateless, lambdas con y sin dato,
//       varias lambdas, reseteo de otros estados al cambiar un campo
//
//  10. SNACKBAR
//     - Las piezas necesarias (state, scope, SnackbarHost en Scaffold)
//     - Lanzar el mensaje, botón de acción y resultado, duración
//     - Alternativa con Text condicional
//
//  11. IMAGE, ICON, PROGRESS, TOPAPPBAR, FAB
//     - Image (recurso, escala, forma, borde degradado) e Icon
//     - Indicadores de progreso circular y lineal, animación del progreso
//     - TopAppBar (y versión centrada) con colores
//     - FloatingActionButton y versión extendida
//     - Mostrar / ocultar elementos con if
//
//  12. ESTRUCTURAS COMPLEJAS
//     A) Pantalla de formulario completa (estado en el padre, resumen condicional,
//        botón habilitado por validación, confirmación que se borra)
//     B) Selector de opciones: el tipo de botón cambia según la selección
//     C) Contador con mínimo y máximo y colores personalizados
//     D) Campo con filtro (teléfono)
//     E) Campo de contraseña con visibilidad
//     F) Layout anidado (Column > Row con pesos > Spacer > Box centrado)
//     G) MainActivity con Scaffold y Snackbar
//     H) Lista que añade y borra elementos
//     I) Estado compartido entre dos hijos
//
//  13. ERRORES TÍPICOS / CHECKLIST
//     - Lista de comprobación de fallos habituales (alineaciones, modifiers,
//       weight, estado, 'by', lambdas, Snackbar, teclado, formas, preview...)
//
// =====================================================================

/* =====================================================================
   0. IMPORTS HABITUALES  (Alt+Enter los añade solos)
   ETIQUETAS: imports, importar, librerias, dependencias, getValue, setValue, alt+enter, error rojo import
   =====================================================================

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*                  // Box, Column, Row, Spacer, padding, size, fillMax..., Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*                         // Button, Text, TextField, Scaffold, Card...
import androidx.compose.runtime.*                           // remember, mutableStateOf, getValue, setValue...
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

   IMPRESCINDIBLES con 'by':
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
*/


/* =====================================================================
   1. KOTLIN BÁSICO
   ETIQUETAS: kotlin, java, sintaxis, lenguaje, basico, javero
   =====================================================================

// ---- Variables ----
// ETIQUETAS: val, var, variable, constante, inmutable, mutable, tipo, inferencia
val a = 5                         // inmutable (final)
var b = 0                         // mutable
val c: String = "hola"            // tipo explícito (detrás de :)
val d: String? = null             // ? = admite null

// ---- Null safety ----
// ETIQUETAS: null, nulo, nullable, ?, ?., ?:, elvis, !!, let, null safety, NullPointer
d?.length                         // llamada segura (null si d es null)
d ?: "defecto"                    // Elvis: valor si es null
d!!                               // fuerza no-null (peta si es null) -> evitar
d?.let { println(it) }            // ejecuta solo si NO es null

// ---- Templates de String ----
// ETIQUETAS: string template, interpolacion, concatenar, $variable, ${expresion}, texto con variables
"Hola $nombre"                    // variable simple
"Total: ${a + b}"                 // expresión
"Valor: ${estado.value}"          // propiedad

// ---- Funciones ----
// ETIQUETAS: funcion, fun, parametros, retorno, valor por defecto, parametro nombrado, expresion, recibe lambda
fun sumar(a: Int, b: Int): Int { return a + b }
fun sumar(a: Int, b: Int) = a + b                 // como expresión
fun saludar(nombre: String, saludo: String = "Hola") = "$saludo, $nombre"
saludar("Ana", saludo = "Buenas")                 // parámetro nombrado
fun hacer(accion: () -> Unit) { accion() }        // recibe lambda

// ---- Condiciones (if es EXPRESIÓN) ----
// ETIQUETAS: if, else, condicion, condicional, &&, ||, !, rango, in, isEmpty, isBlank, comparar
val x = if (a > 3) "grande" else "pequeño"
if (a > 1 && b < 5 || !flag) { }
if (a in 1..10) { }               // rango incluido
if (a !in 1..10) { }
if (texto.isEmpty()) { }          // isNotEmpty(), isBlank(), isNotBlank()

// ---- when (como switch, es expresión, sin break) ----
// ETIQUETAS: when, switch, case, seleccion multiple, rangos, is, else
val r = when (n) {
    1 -> "uno"
    2, 3 -> "dos o tres"
    in 4..10 -> "rango"
    is String -> "es String"
    else -> "otro"
}
when {                            // when sin argumento = if/else if
    n < 5 -> "suspenso"
    n < 7 -> "aprobado"
    else -> "notable"
}

// ---- Bucles ----
// ETIQUETAS: for, while, repeat, bucle, loop, until, downTo, step, withIndex, recorrer
for (i in 1..5) { }               // 1,2,3,4,5
for (i in 1 until 5) { }          // 1,2,3,4
for (i in 5 downTo 1 step 2) { }
for (item in lista) { }
for ((i, item) in lista.withIndex()) { }
repeat(3) { println(it) }
while (cond) { }

// ---- Colecciones ----
// ETIQUETAS: lista, list, mutableListOf, listOf, mapa, map, filter, sum, sorted, any, all, joinToString, array, coleccion
val l = listOf(1, 2, 3)                   // solo lectura
val m = mutableListOf(1, 2, 3)            // add, remove, removeAt, clear
val mapa = mapOf("a" to 1)                // clave to valor
l.filter { it > 1 }.map { it * 10 }
l.size  l.first()  l.last()  l.isEmpty()  l.contains(2)
l.sum()  l.max()  l.sorted()  l.any { it > 2 }  l.all { it > 0 }
l.joinToString(", ")

// ---- Strings útiles ----
// ETIQUETAS: string, cadena, length, trim, take, replace, contains, toIntOrNull, isDigit, isLetter, filter, solo digitos, mayusculas, minusculas
s.length  s.uppercase()  s.lowercase()  s.trim()  s.take(9)  s.drop(1)
s.replace("a", "")  s.contains("@")  s.startsWith("6")  s.toIntOrNull()
s.all { it.isDigit() }            // solo dígitos
s.filter { it.isDigit() }         // se queda solo con dígitos
c.isDigit()  c.isLetter()  c.isLetterOrDigit()

// ---- Clases ----
// ETIQUETAS: clase, data class, enum, extension, copy, desestructuracion, objeto, POJO
data class Persona(val nombre: String, val edad: Int)     // equals, toString, copy...
val p2 = p1.copy(edad = 26)
val (nom, ed) = p1                                        // desestructuración
enum class Zona { TERRAZA, INTERIOR, BARRA }
Zona.TERRAZA.name   Zona.values()
fun String.esEmail() = this.contains("@")                 // función de extensión

// ---- Lambdas ----
// ETIQUETAS: lambda, funcion anonima, it, trailing lambda, () -> Unit, (String) -> Unit, flecha, callback, evento, onClick
val sumar: (Int, Int) -> Int = { a, b -> a + b }          // { params -> cuerpo }
val doble: (Int) -> Int = { it * 2 }                      // 'it' = único parámetro
val aviso: () -> Unit = { println("hola") }               // Unit = void
// REGLA: si nombras el parámetro ('x ->') NO existe 'it'.
// TRAILING LAMBDA: si es el último parámetro va fuera de los ( ):
//    Boton(onClick = { })   ==   Boton() { }   ==   Boton { }
// Tipos que más salen:
//    () -> Unit            aviso sin dato (onClick)
//    (String) -> Unit      aviso con texto (onValueChange)
//    (Int) -> Unit         aviso con número
//    (Boolean) -> Unit     aviso con booleano (Checkbox, Switch)
//    @Composable () -> Unit   contenido composable (label, trailingIcon, content)
*/


/* =====================================================================
   2. MAINACTIVITY + SCAFFOLD
   ETIQUETAS: main, mainactivity, activity, scaffold, setContent, tema, theme, innerPadding, preview, pantalla principal
   =====================================================================

class MainActivity : ComponentActivity() {
// ETIQUETAS: MainActivity, onCreate, setContent, enableEdgeToEdge, tema, theme, innerPadding, llamar composable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {                         // nombre del tema de TU proyecto
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MiPantalla(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

// Scaffold con TODAS sus ranuras (todas opcionales):
// ETIQUETAS: scaffold, topBar, bottomBar, floatingActionButton, snackbarHost, containerColor, estructura de pantalla
Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = { MyTopAppBar() },
    bottomBar = { },
    floatingActionButton = { MyFAB() },
    floatingActionButtonPosition = FabPosition.End,        // Start, Center, End
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    containerColor = Color.White
) { innerPadding -> /* contenido: usa innerPadding en la raíz */ }

// Preview (SIN parámetros)
// ETIQUETAS: preview, previsualizar, vista previa, showSystemUi, showBackground, widthDp, heightDp
@Preview(showBackground = true, showSystemUi = true, widthDp = 400, heightDp = 800)
@Composable
fun MiPreview() { MyApplicationTheme { MiPantalla() } }
*/


/* =====================================================================
   3. MODIFIER  (el ORDEN importa: se aplica de arriba abajo)
   ETIQUETAS: modifier, modificador, tamaño, padding, margen, fondo, borde, clic, scroll, orden, weight, alineacion
   =====================================================================

// REGLA DE ORO: raíz -> 'modifier' (el recibido) | hijos -> 'Modifier' (nuevo)
// ETIQUETAS: modifier vs Modifier, mayuscula minuscula, parametro modifier, raiz, hijos, regla de oro, valor por defecto
@Composable
fun MiPantalla(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {   // raíz
        Text("Hola", modifier = Modifier.padding(8.dp))           // hijo
    }
}

// ---- TAMAÑO ----
// ETIQUETAS: tamaño, size, fillMaxSize, fillMaxWidth, fillMaxHeight, width, height, ancho, alto, widthIn, aspectRatio, ocupar todo
.fillMaxSize()  .fillMaxWidth()  .fillMaxHeight()
.fillMaxWidth(0.5f)               // 50% del ancho disponible
.size(50.dp)                      // ancho y alto iguales
.size(width = 100.dp, height = 40.dp)
.width(40.dp)  .height(33.dp)
.widthIn(min = 100.dp, max = 300.dp)   // heightIn(...) igual
.defaultMinSize(minWidth = 80.dp)
.wrapContentSize()                // vuelve a tamaño mínimo
.aspectRatio(1f)                  // ancho/alto

// ---- REPARTO (solo hijo DIRECTO de Row/Column) ----
// ETIQUETAS: weight, peso, repartir, proporcion, reparto, espacio equitativo
.weight(1f)                       // Column: reparte ALTO | Row: reparte ANCHO
.weight(1f, fill = false)

// ---- ESPACIADO ----
// ETIQUETAS: padding, margen, margin, espaciado, separacion, relleno, horizontal vertical, start end top bottom
.padding(16.dp)                                   // 4 lados
.padding(horizontal = 16.dp, vertical = 8.dp)
.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp)
// NO existe margin: margen = padding ANTES de background/border
// innerPadding = padding DESPUÉS de background

// ---- FONDO, BORDE, FORMA ----
// ETIQUETAS: background, fondo, border, borde, clip, recortar, shadow, sombra, alpha, transparencia, esquinas redondeadas, color de fondo
.background(Color.Red)
.background(Color(0xFFE3F2FD), shape = RoundedCornerShape(12.dp))
.background(Color.Red, CircleShape)
.border(2.dp, Color.Blue, RoundedCornerShape(8.dp))
.clip(RoundedCornerShape(16.dp))  // recorta el contenido a la forma
.shadow(4.dp)                     // sombra
.alpha(0.5f)                      // transparencia

// ---- INTERACCIÓN ----
// ETIQUETAS: clickable, clic, pulsar, click, scroll, verticalScroll, horizontalScroll, rememberScrollState, desplazamiento
.clickable { /* acción */ }
.clickable(enabled = false) { }
.verticalScroll(rememberScrollState())
.horizontalScroll(rememberScrollState())

// ---- POSICIÓN DENTRO DE UN PADRE ----
// ETIQUETAS: align, alineacion de un hijo, offset, desplazar, posicion, centrar un hijo
// (alineación de un hijo concreto, sin tocar al resto)
.align(Alignment.CenterHorizontally)    // hijo de Column
.align(Alignment.CenterVertically)      // hijo de Row
.align(Alignment.BottomEnd)             // hijo de Box
.offset(x = 10.dp, y = 5.dp)

// ---- Formas ----
// ETIQUETAS: shape, forma, RoundedCornerShape, CircleShape, esquinas, circulo, pildora, redondeado, porcentaje
RoundedCornerShape(10.dp)         // radio fijo
RoundedCornerShape(10)            // PORCENTAJE (100 = píldora)
RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
CircleShape  RectangleShape

// ---- Colores ----
// ETIQUETAS: color, Color, hexadecimal, 0xFF, rojo, azul, MaterialTheme, colorScheme, copy alpha, transparente
Color.Red  Color.Blue  Color.Green  Color.Yellow  Color.Black  Color.White
Color.Gray  Color.LightGray  Color.DarkGray  Color.Cyan  Color.Magenta  Color.Transparent
Color(0xFF1565C0)                 // ARGB hexadecimal (FF = opaco)
Color.Red.copy(alpha = 0.3f)
MaterialTheme.colorScheme.primary / secondary / background / surface / error
*/


/* =====================================================================
   4. LAYOUTS
   ETIQUETAS: layout, disposicion, column, row, box, spacer, columna, fila, caja, lista, card, tarjeta, separador
   =====================================================================

// Column = vertical | Row = horizontal | Box = capas | el orden del código = orden en pantalla

// ---- COLUMN ----
// ETIQUETAS: column, columna, vertical, verticalArrangement, horizontalAlignment, apilar
Column(
    modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,                  // eje del apilado
    horizontalAlignment = Alignment.CenterHorizontally         // eje cruzado
) { }

// ---- ROW ----
// ETIQUETAS: row, fila, horizontal, horizontalArrangement, verticalAlignment, lado a lado
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceEvenly,           // eje del apilado
    verticalAlignment = Alignment.CenterVertically             // eje cruzado
) { }

// ---- BOX ----
// ETIQUETAS: box, caja, capas, superponer, contentAlignment, centrar, apilar encima
Box(
    modifier = Modifier.size(200.dp).background(Color.Red),
    contentAlignment = Alignment.Center        // SOLO existe en Box (afecta a hijos directos)
) { }

// Arrangement:  Start, End, Center, Top, Bottom,
// ETIQUETAS: arrangement, SpaceBetween, SpaceEvenly, SpaceAround, spacedBy, alignment, Center, CenterHorizontally, CenterVertically, distribuir
//               SpaceBetween (extremos pegados), SpaceEvenly (huecos iguales),
//               SpaceAround, spacedBy(8.dp) (separación fija entre hijos)
Column(verticalArrangement = Arrangement.spacedBy(8.dp)) { }   // evita Spacers
// Alignment horizontal (Column): Start, CenterHorizontally, End
// Alignment vertical   (Row):    Top, CenterVertically, Bottom
// Alignment 2D (Box):  TopStart, TopCenter, TopEnd, CenterStart, Center,
//                      CenterEnd, BottomStart, BottomCenter, BottomEnd

// ---- SPACER ----
// ETIQUETAS: spacer, espacio, separador, hueco, separar elementos, empujar
Spacer(modifier = Modifier.height(16.dp))      // en Column
Spacer(modifier = Modifier.width(8.dp))        // en Row
Spacer(modifier = Modifier.weight(1f))         // empuja: ocupa todo el espacio libre

// ---- Para que centrar en vertical funcione la Column necesita ALTO (fillMaxSize) ----
// ---- Un Box vacío sin tamaño mide 0 ----

// ---- CARD / SURFACE ----
// ETIQUETAS: card, tarjeta, surface, superficie, elevation, contenedor con sombra
Card(
    modifier = Modifier.fillMaxWidth(),
    shape = RoundedCornerShape(12.dp),
    colors = CardDefaults.cardColors(containerColor = Color.White),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
) { Column(Modifier.padding(16.dp)) { } }
Surface(color = Color.White, shape = RoundedCornerShape(8.dp), shadowElevation = 4.dp) { }

// ---- SEPARADOR ----
// ETIQUETAS: divider, linea, separador, HorizontalDivider
HorizontalDivider(thickness = 1.dp, color = Color.Gray)

// ---- LISTA EFICIENTE (con scroll propio, NO dentro de verticalScroll) ----
// ETIQUETAS: lazycolumn, lazyrow, lista, items, itemsIndexed, recyclerview, scroll de lista
LazyColumn(
    modifier = Modifier.fillMaxSize(),
    contentPadding = PaddingValues(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
) {
    items(lista) { elemento -> Text(elemento) }
    item { Text("Un único elemento") }
    itemsIndexed(lista) { indice, elemento -> }
}
// (LazyRow = igual en horizontal)

// ---- REPARTIR EN UNA ROW ----
// ETIQUETAS: repartir, equitativo, mitad, dos botones, mismo ancho, weight vs SpaceEvenly
// a) Cada hijo OCUPA parte del ancho:  weight(1f) en cada hijo
// b) Hijos conservan tamaño, se reparte el hueco: horizontalArrangement = SpaceEvenly
// No mezclar ambos: con weight no queda hueco.
*/


/* =====================================================================
   5. TEXT
   ETIQUETAS: text, texto, etiqueta de texto, fuente, tipografia, letra, color de texto, negrita, cursiva, tamaño de letra
   =====================================================================

// ETIQUETAS: text, texto, color, fontSize, fontWeight, fontStyle, letterSpacing, textAlign, textDecoration, maxLines, overflow, Ellipsis, style, typography, subrayado, tachado, negrita, cursiva, centrar texto
Text(
    text = "Hola",                                 // OBLIGATORIO
    modifier = Modifier.fillMaxWidth(),            // textAlign solo se nota si ocupa ancho
    color = Color(0xFF1565C0),
    fontSize = 22.sp,                              // sp para letra, dp para medidas
    fontStyle = FontStyle.Italic,                  // Normal
    fontWeight = FontWeight.SemiBold,              // Normal, Medium, SemiBold, Bold, ExtraBold, Light
    fontFamily = FontFamily.Monospace,             // Serif, SansSerif, Cursive
    letterSpacing = 3.sp,
    lineHeight = 30.sp,
    textDecoration = TextDecoration.Underline,     // LineThrough; combinar: Underline + LineThrough
    textAlign = TextAlign.Center,                  // Start, End, Justify
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,              // puntos suspensivos
    style = MaterialTheme.typography.titleLarge    // headlineLarge, bodyMedium, labelSmall...
)
// Texto como "enlace":  Text("link", color = Color.Blue, textDecoration = Underline, modifier = Modifier.clickable { })
// ETIQUETAS: enlace, link, texto clicable, texto condicional, texto segun estado, mostrar solo si
// Texto condicional:    if (condicion) { Text("...") }
// Texto según estado:   Text(if (oculto) "Mostrar" else "Ocultar")
*/


/* =====================================================================
   6. TEXTFIELD / OUTLINEDTEXTFIELD  (misma API; Outlined lleva borde)
   ETIQUETAS: campo de texto, textfield, input, entrada, formulario, outlined, teclado, contraseña, password, filtro, validacion
   =====================================================================

// ETIQUETAS: campo de texto, textfield, outlinedtextfield, value, onValueChange, label, placeholder, readOnly, leadingIcon, trailingIcon, supportingText, isError, singleLine, keyboardOptions, KeyboardType, ImeAction, visualTransformation, PasswordVisualTransformation, colors, shape, input
OutlinedTextField(
    value = texto,                                 // OBLIGATORIO (String)
    onValueChange = { texto = it },                // OBLIGATORIO ((String) -> Unit)
    modifier = Modifier.fillMaxWidth(),
    enabled = true,
    readOnly = false,                              // no editable pero seleccionable
    label = { Text("Nombre") },                    // flota arriba al enfocar
    placeholder = { Text("Ej: Pepe") },            // aparece cuando está vacío y enfocado
    leadingIcon = { Text("+34") },                 // composable al INICIO
    trailingIcon = { Text("Mostrar", Modifier.clickable { }) },   // al FINAL
    supportingText = { Text("Mensaje de ayuda o error") },        // texto debajo
    isError = texto.length < 3,                    // pinta el campo en rojo
    singleLine = true,                             // una línea (si no, crece)
    maxLines = 3,  minLines = 1,
    keyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Text,          // Number, Phone, Email, Password, Decimal, Uri
        imeAction = ImeAction.Next                 // Done, Search, Send, Go, Previous
    ),
    keyboardActions = KeyboardActions(onDone = { /* al pulsar Done */ }),
    visualTransformation = PasswordVisualTransformation(),   // puntos | VisualTransformation.None
    shape = RoundedCornerShape(12.dp),
    colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Blue, unfocusedBorderColor = Color.Gray
    )
)
// keyboardOptions = QUÉ TECLADO sale. visualTransformation = CÓMO SE DIBUJA el texto. Independientes.
// TextField = mismo parámetros con colors = TextFieldDefaults.colors(...)
// BasicTextField = sin decoración (diseño propio)

// ---- FILTROS en onValueChange (tú decides si aceptas la entrada) ----
// ETIQUETAS: filtro, solo numeros, solo digitos, maximo caracteres, limitar longitud, ignorar entrada, validar al escribir, telefono, mayusculas, replace, isDigit
onValueChange = { if (it.all { c -> c.isDigit() } && it.length <= 9) onChange(it) }   // solo dígitos y máx. 9
onValueChange = { onChange(it.filter { c -> c.isDigit() }.take(9)) }                  // limpia en vez de ignorar
onValueChange = { onChange(it.replace("a", "")) }                                      // quita letras 'a'
onValueChange = { onChange(it.uppercase()) }                                           // fuerza mayúsculas
onValueChange = { if (it.length <= 20) onChange(it) }                                  // longitud máxima
// Isdigits sin librerías: it.all { c -> c.isDigit() }  (androidx.core.text.isDigitsOnly también vale)

// ---- Validaciones típicas (para isError / enabled de botones) ----
// ETIQUETAS: validacion, validar, email, telefono 9 digitos, pin 4 caracteres, formulario valido, isError, enabled boton
val telefonoOk = telefono.length == 9
val emailOk = email.contains("@") && email.contains(".")
val pinOk = pin.length >= 4
val formularioOk = nombre.isNotBlank() && telefonoOk && pinOk

// ---- CAMPO CONTRASEÑA con mostrar/ocultar ----
// ETIQUETAS: contraseña, password, pin, mostrar ocultar, PasswordVisualTransformation, VisualTransformation.None, trailingIcon, ojo
var oculto by rememberSaveable { mutableStateOf(true) }
OutlinedTextField(
    value = pin, onValueChange = onPinChange, label = { Text("PIN") }, singleLine = true,
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    visualTransformation = if (oculto) PasswordVisualTransformation() else VisualTransformation.None,
    trailingIcon = {
        Text(
            text = if (oculto) "Mostrar" else "Ocultar",
            modifier = Modifier.clickable { oculto = !oculto }.padding(end = 12.dp)
        )
    }
)
*/


/* =====================================================================
   7. BOTONES  (jerarquía Material 3: de más a menos importante)
   ETIQUETAS: boton, button, outlined, textbutton, elevated, tonal, iconbutton, onclick, enabled, habilitado, deshabilitado, contador +/-
   =====================================================================

// ETIQUETAS: tipos de boton, Button, FilledTonalButton, ElevatedButton, OutlinedButton, TextButton, jerarquia, importancia, principal secundario
Button(onClick = { }) { Text("Principal") }             // acción principal (Guardar, Enviar)
FilledTonalButton(onClick = { }) { Text("Tonal") }      // intermedio
ElevatedButton(onClick = { }) { Text("Sombra") }        // con sombra
OutlinedButton(onClick = { }) { Text("Media") }         // borde, sin fondo (Editar, Ver)
TextButton(onClick = { }) { Text("Cancelar") }          // baja importancia, sin borde ni fondo

// ETIQUETAS: boton, button, onClick, enabled, shape, colors, ButtonDefaults, buttonColors, containerColor, contentColor, disabledContainerColor, elevation, border, BorderStroke, contentPadding, interactionSource, content, RowScope
Button(
    onClick = { },                                       // OBLIGATORIO
    modifier = Modifier.fillMaxWidth().padding(8.dp),
    enabled = cantidad > 1,                              // false = ignora clics y se atenúa
    shape = RoundedCornerShape(100),                     // sin unidad = % (100 = píldora) | 10.dp = radio fijo
    colors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue, contentColor = Color.White,
        disabledContainerColor = Color.Gray, disabledContentColor = Color.DarkGray
    ),
    elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp, pressedElevation = 20.dp),
    border = BorderStroke(2.dp, Color.Red),              // se dibuja encima, no agranda
    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),   // espacio borde-contenido
    interactionSource = null                             // casi nunca se toca
) { Text("Púlsame", color = Color.Blue) }                // content = RowScope (hijos en horizontal); el color del Text GANA

// Otros colors:  ButtonDefaults.outlinedButtonColors(...), textButtonColors(...),
//                filledTonalButtonColors(...), elevatedButtonColors(...)
// Elevación:     ButtonDefaults.elevatedButtonElevation(pressedElevation = 20.dp)

// Botón con icono + texto (el content es una Row):
// ETIQUETAS: boton con icono, icono y texto, Icon dentro de Button
Button(onClick = { }) { Icon(painterResource(R.drawable.ico), null); Spacer(Modifier.width(8.dp)); Text("Añadir") }

// IconButton (solo icono):
// ETIQUETAS: iconbutton, boton solo icono, boton redondo
IconButton(onClick = { }) { Icon(painterResource(R.drawable.ico), contentDescription = null) }

// Botón + / - con límites (patrón contador):
// ETIQUETAS: contador, mas menos, + -, incrementar, decrementar, minimo, maximo, coerceIn, coerceAtLeast, deshabilitar en el limite, cantidad
Button(onClick = { if (cantidad > 0) cantidad-- }) { Text("-") }
Button(onClick = { cantidad-- }, enabled = cantidad > 1) { Text("-") }      // deshabilitado en el mínimo
Button(onClick = { cantidad++ }, enabled = cantidad < 10) { Text("+") }     // deshabilitado en el máximo
Button(onClick = { cantidad = (cantidad + 1).coerceAtMost(10) }) { }        // coerceAtLeast(1) / coerceIn(1, 10)
*/


/* =====================================================================
   8. OTROS CONTROLES
   ETIQUETAS: checkbox, casilla, switch, interruptor, radiobutton, radio, slider, deslizador, desplegable, dropdown, spinner, menu, dialogo, alertdialog, popup
   =====================================================================

// ---- CHECKBOX ----
// ETIQUETAS: checkbox, casilla, marcar, checked, onCheckedChange, aceptar condiciones
var marcado by rememberSaveable { mutableStateOf(false) }
Row(verticalAlignment = Alignment.CenterVertically) {
    Checkbox(checked = marcado, onCheckedChange = { marcado = it })     // (Boolean) -> Unit
    Text("Acepto condiciones", modifier = Modifier.clickable { marcado = !marcado })
}

// ---- SWITCH ----
// ETIQUETAS: switch, interruptor, activar desactivar, toggle
Switch(checked = activo, onCheckedChange = { activo = it })

// ---- RADIOBUTTON (grupo: UNA variable guarda la opción elegida) ----
// ETIQUETAS: radiobutton, radio, opcion unica, seleccionar uno, grupo de opciones, selected
var opcion by rememberSaveable { mutableStateOf("Terraza") }
listOf("Terraza", "Interior", "Barra").forEach { zona ->
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { opcion = zona }) {
        RadioButton(selected = opcion == zona, onClick = { opcion = zona })
        Text(zona)
    }
}

// ---- SLIDER ----
// ETIQUETAS: slider, deslizador, barra, valueRange, steps, rango de valores
Slider(value = valor, onValueChange = { valor = it }, valueRange = 0f..10f, steps = 9)   // valor: Float

// ---- DESPLEGABLE (DropdownMenu clásico) ----
// ETIQUETAS: desplegable, dropdown, DropdownMenu, DropdownMenuItem, menu, spinner, expanded, lista desplegable
var expandido by rememberSaveable { mutableStateOf(false) }
var seleccion by rememberSaveable { mutableStateOf("Elige") }
Box {
    OutlinedButton(onClick = { expandido = true }) { Text(seleccion) }
    DropdownMenu(expanded = expandido, onDismissRequest = { expandido = false }) {
        listOf("Fácil", "Media", "Difícil").forEach { opcion ->
            DropdownMenuItem(
                text = { Text(opcion) },
                onClick = { seleccion = opcion; expandido = false }
            )
        }
    }
}

// ---- DESPLEGABLE tipo formulario (ExposedDropdownMenuBox) ----
// ETIQUETAS: desplegable formulario, ExposedDropdownMenuBox, menuAnchor, combo, select, comboBox, ExperimentalMaterial3Api, OptIn
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Desplegable(opciones: List<String>, seleccion: String, onSeleccion: (String) -> Unit) {
    var expandido by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expandido, onExpandedChange = { expandido = !expandido }) {
        OutlinedTextField(
            value = seleccion, onValueChange = { }, readOnly = true,
            label = { Text("Dificultad") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido) },
            modifier = Modifier.menuAnchor()      // en versiones nuevas: menuAnchor(MenuAnchorType.PrimaryNotEditable)
        )
        ExposedDropdownMenu(expanded = expandido, onDismissRequest = { expandido = false }) {
            opciones.forEach { op ->
                DropdownMenuItem(text = { Text(op) }, onClick = { onSeleccion(op); expandido = false })
            }
        }
    }
}

// ---- ALERTDIALOG (diálogo de confirmación) ----
// ETIQUETAS: dialogo, dialog, AlertDialog, popup, confirmar, ventana emergente, confirmButton, dismissButton
if (mostrarDialogo) {
    AlertDialog(
        onDismissRequest = { mostrarDialogo = false },
        title = { Text("Confirmar") },
        text = { Text("¿Seguro?") },
        confirmButton = { TextButton(onClick = { mostrarDialogo = false }) { Text("Aceptar") } },
        dismissButton = { TextButton(onClick = { mostrarDialogo = false }) { Text("Cancelar") } }
    )
}
*/


/* =====================================================================
   9. ESTADO, RECOMPOSICIÓN Y STATE HOISTING
   ETIQUETAS: estado, state, remember, rememberSaveable, by, mutableStateOf, recomposicion, rotacion, state hoisting, stateless, stateful, udf, lambda hijo padre, lista con estado
   =====================================================================

// Por qué fallan las versiones incompletas:
// ETIQUETAS: estado, state, remember, rememberSaveable, mutableStateOf, by, recomposicion, rotar pantalla, no se actualiza, se reinicia, .value, getValue, setValue, Bundle
var n = 0                                       // NO recompone la UI (Compose no lo observa)
var n = mutableStateOf(0)                       // recompone, pero se REINICIA a 0 en cada recomposición
var n = remember { mutableStateOf(0) }          // aguanta recomposiciones (usa .value)
var n by rememberSaveable { mutableIntStateOf(0) }   // + aguanta ROTACIÓN (Bundle). FORMA FINAL

// Requiere imports getValue y setValue. Con 'by' no se escribe .value.
// remember: RAM del árbol de composición (se pierde al rotar: Activity destruida y recreada)
// rememberSaveable: guarda en Bundle (solo tipos empaquetables: Int, String, Boolean, Float...)

// Tipos de estado:
// ETIQUETAS: mutableIntStateOf, mutableStateOf, mutableFloatStateOf, tipos de estado, Int String Boolean, boxing
mutableIntStateOf(0)  mutableLongStateOf(0L)  mutableFloatStateOf(0f)  mutableDoubleStateOf(0.0)
mutableStateOf("")    mutableStateOf(true)    mutableStateOf(0)   // String, Boolean (y Int también vale)

// Estado derivado (se calcula de otros estados, NO hace falta guardarlo):
// ETIQUETAS: derivedStateOf, estado derivado, calculado, variable calculada
val resumenVisible = nombre.isNotBlank() && telefono.length == 9      // simple: variable normal basta
val resumenVisible by remember { derivedStateOf { nombre.isNotBlank() && telefono.length == 9 } }

// Lista con estado (objetos no empaquetables: remember, no rememberSaveable):
// ETIQUETAS: mutableStateListOf, lista de estado, lista que cambia, add remove, objeto en estado
val lista = remember { mutableStateListOf<String>() }
lista.add("x")  lista.remove("x")  lista.clear()
// Enum o clase propia con rememberSaveable: da error si no es Parcelable/Serializable;
// por eso guarda String o Int (nombre o índice) y conviértelo.

// Cambio de valor desde evento:
// ETIQUETAS: cambiar estado, modificar valor, onClick estado, it, onValueChange
Button(onClick = { n += 1 }) { }
Modifier.clickable { n++ }
onValueChange = { texto = it }

// ================== STATE HOISTING (UDF) ==================
// ETIQUETAS: state hoisting, elevar estado, stateless, stateful, UDF, unidirectional data flow, padre hijo, datos bajan eventos suben, lambda, onTextoChange, onClick parametro, fuente unica de verdad
// Datos BAJAN (parámetros) | Eventos SUBEN (lambdas)
// Estado SOLO en el padre; hijos STATELESS (sin remember de datos compartidos)
// Excepción aceptada: estado puramente visual de un hijo (p.ej. mostrar/ocultar contraseña)

@Composable
fun Padre(modifier: Modifier = Modifier) {
    var texto by rememberSaveable { mutableStateOf("") }
    var cantidad by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier = modifier.padding(16.dp)) {
        CampoTexto(texto) { texto = it }                         // dato + lambda con dato (it = texto nuevo)
        Contador(cantidad, onMenos = { cantidad-- }, onMas = { cantidad++ })   // varias lambdas
    }
}

@Composable
fun CampoTexto(texto: String, onTextoChange: (String) -> Unit) {
    OutlinedTextField(value = texto, onValueChange = { onTextoChange(it) })
}

@Composable
fun Contador(valor: Int, onMenos: () -> Unit, onMas: () -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(onClick = onMenos, enabled = valor > 0) { Text("-") }     // pasar la lambda directa: onClick = onMenos
        Spacer(Modifier.width(10.dp))
        Text("$valor")
        Spacer(Modifier.width(10.dp))
        Button(onClick = onMas) { Text("+") }
    }
}
// Llamada con trailing lambda: solo la ÚLTIMA lambda va fuera de los ( )
// Si dos hijos necesitan el mismo dato: el estado sube al padre común.
// Para "al cambiar X, resetear Y": ponlo dentro de la lambda del padre:
//    CampoNombre(nombre) { nombre = it; confirmada = false }
*/


/* =====================================================================
   10. SNACKBAR  (necesita 3 piezas: el Scaffold dibuja, el scope lanza)
   ETIQUETAS: snackbar, mensaje emergente, aviso, toast, notificacion, showSnackbar, corrutina, scope, launch
   =====================================================================

// En el padre (o MainActivity):
// ETIQUETAS: snackbar, SnackbarHostState, rememberCoroutineScope, SnackbarHost, scaffold snackbarHost, no sale el snackbar, mensaje
val snackbarHostState = remember { SnackbarHostState() }
val scope = rememberCoroutineScope()

Scaffold(
    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }      // <- SIN ESTO NO SE VE
) { innerPadding -> }

// Al lanzarlo (showSnackbar es suspend: va dentro de launch):
// ETIQUETAS: showSnackbar, scope.launch, corrutina, suspend, actionLabel, SnackbarDuration, SnackbarResult, ActionPerformed, deshacer
scope.launch {
    val resultado = snackbarHostState.showSnackbar(
        message = "Reserva confirmada",
        actionLabel = "Deshacer",                          // opcional (botón de acción)
        duration = SnackbarDuration.Short                   // Short, Long, Indefinite
    )
    if (resultado == SnackbarResult.ActionPerformed) { /* pulsó Deshacer */ }
    else { /* se cerró (Dismissed) */ }
}
// Alternativa sin Snackbar (más segura con el temario): if (confirmada) Text("Confirmada")
*/


/* =====================================================================
   11. IMAGE, ICON, PROGRESS, TOPAPPBAR, FAB
   ETIQUETAS: imagen, image, icono, icon, progreso, progress, barra de carga, circular, linear, topappbar, barra superior, fab, boton flotante, drawable, painterResource
   =====================================================================

// ---- IMAGE (drawables en res/drawable) ----
// ETIQUETAS: imagen, image, painterResource, drawable, R.drawable, contentScale, Crop, contentDescription, borde degradado, Brush, foto
Image(
    painter = painterResource(R.drawable.floripondio),
    contentDescription = "Flor",                  // null si es decorativa
    contentScale = ContentScale.Crop,             // Fit, FillBounds, Inside, FillWidth
    modifier = Modifier.size(180.dp).clip(RoundedCornerShape(16.dp))
        .border(4.dp, Brush.linearGradient(listOf(Color.Green, Color.Blue)), RoundedCornerShape(16.dp))
)
// ---- ICON (vectorial) ----
// ETIQUETAS: icono, icon, tint, vector, svg, Icons.Default
Icon(painter = painterResource(R.drawable.ico), contentDescription = null,
     tint = Color.Blue, modifier = Modifier.size(60.dp))
// Icons.Default.* necesita la librería material-icons-extended.

// ---- PROGRESS ----
// ETIQUETAS: progreso, progress, CircularProgressIndicator, LinearProgressIndicator, barra de carga, loading, cargando, animateFloatAsState, trackColor, strokeCap, strokeWidth
CircularProgressIndicator(                         // sin 'progress' = indeterminado (gira)
    progress = { 0.5f },                           // 0f..1f (lambda)
    modifier = Modifier.size(120.dp), color = Color.Green,
    strokeWidth = 12.dp, trackColor = Color.LightGray, strokeCap = StrokeCap.Round
)
LinearProgressIndicator(progress = { 0.5f }, color = Color.Red, trackColor = Color.LightGray, strokeCap = StrokeCap.Round)
val animado by animateFloatAsState(targetValue = progreso)       // transición suave
var progreso by remember { mutableFloatStateOf(0.5f) }           // estado Float

// ---- TOPAPPBAR ----
// ETIQUETAS: topappbar, barra superior, appbar, titulo, navigationIcon, actions, CenterAlignedTopAppBar, topAppBarColors
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text("Mi app") },
        navigationIcon = { Icon(painterResource(R.drawable.ico), null) },
        actions = { Icon(painterResource(R.drawable.ico), null) },       // RowScope: varios iconos
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black, titleContentColor = Color.White,
            navigationIconContentColor = Color.Yellow, actionIconContentColor = Color.Green
        )
    )
}
// CenterAlignedTopAppBar(...) = título centrado, mismos parámetros

// ---- FAB ----
// ETIQUETAS: fab, boton flotante, FloatingActionButton, ExtendedFloatingActionButton, boton circular
FloatingActionButton(
    onClick = { }, shape = RoundedCornerShape(100),
    containerColor = Color.Green, contentColor = Color.White,
    elevation = FloatingActionButtonDefaults.elevation(12.dp)
) { Icon(painterResource(R.drawable.ico), null) }
// ExtendedFloatingActionButton(onClick = { }, icon = { }, text = { Text("Nuevo") })

// ---- Quitar/mostrar elementos ----
// ETIQUETAS: mostrar ocultar elemento, visibilidad, if composable, isLoading, condicional
if (isLoading) { CircularProgressIndicator() }    // la visibilidad es un if sobre un estado
*/


/* =====================================================================
   12. ESTRUCTURAS COMPLEJAS (patrones de examen)
   ETIQUETAS: ejemplos completos, patrones, formulario completo, reserva, pedido, ficha, selector, contador, filtro, layout anidado, lista tareas, examen
   =====================================================================

// ---------- A) PANTALLA TIPO FORMULARIO COMPLETA ----------
// ETIQUETAS: formulario completo, pantalla entera, reserva, pedido, ficha, cabecera, resumen condicional, confirmar, limpiar, mensaje de confirmacion, estado en el padre, todo junto
@Composable
fun FormularioScreen(modifier: Modifier = Modifier) {
    // TODO el estado en el padre
    var nombre by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }
    var pin by rememberSaveable { mutableStateOf("") }
    var cantidad by rememberSaveable { mutableIntStateOf(1) }
    var zona by rememberSaveable { mutableStateOf("Terraza") }
    var confirmada by rememberSaveable { mutableStateOf(false) }

    // Derivados (variables normales: se recalculan en cada recomposición)
    val resumenVisible = nombre.isNotBlank() && telefono.length == 9
    val puedeConfirmar = resumenVisible && pin.length >= 4

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabecera con fondo redondeado
        Box(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xFFFFF3E0), shape = RoundedCornerShape(12.dp))
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) { Text("TÍTULO", color = Color(0xFFE65100), fontSize = 22.sp, fontWeight = FontWeight.SemiBold) }

        Spacer(Modifier.height(16.dp))

        // Hijos stateless: reciben valor + lambda; al cambiar, se borra la confirmación
        CampoNombre(nombre) { nombre = it; confirmada = false }
        Spacer(Modifier.height(16.dp))
        CampoTelefono(telefono) { telefono = it; confirmada = false }

        // Resumen condicional
        if (resumenVisible) {
            Text("Reserva para $nombre: $cantidad comensales en $zona. Tel: $telefono")
        }

        // Botones de acción repartidos
        Row(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = { nombre = ""; telefono = ""; pin = ""; cantidad = 1; zona = "Terraza"; confirmada = false },
                modifier = Modifier.weight(1f)
            ) { Text("Limpiar") }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = { confirmada = true },
                enabled = puedeConfirmar,
                modifier = Modifier.weight(1f)
            ) { Text("Confirmar") }
        }
        if (confirmada) { Text("✔ Reserva confirmada") }
    }
}

// ---------- B) SELECTOR: el tipo de botón depende del estado (if/else) ----------
// ETIQUETAS: selector, boton seleccionado, Button vs OutlinedButton, zona, opcion elegida, tipo de boton segun estado, if else, tabs, chips
@Composable
fun SelectorZona(zona: String, onZonaChange: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        listOf("Terraza", "Interior", "Barra").forEach { nombre ->
            if (zona == nombre) {
                Button(onClick = { onZonaChange(nombre) }, modifier = Modifier.weight(1f)) { Text(nombre) }
            } else {
                OutlinedButton(onClick = { onZonaChange(nombre) }, modifier = Modifier.weight(1f)) { Text(nombre) }
            }
            Spacer(Modifier.width(8.dp))
        }
    }
}
// Versión sin forEach: repite el if/else tres veces con cada nombre a mano.
// Alternativa de un solo botón: cambiar solo colors según estado:
//    colors = ButtonDefaults.buttonColors(containerColor = if (zona == nombre) Color.Blue else Color.Gray)

// ---------- C) CONTADOR CON MÍNIMO/MÁXIMO ----------
// ETIQUETAS: contador, cantidad, + -, minimo maximo, enabled, pildora, disabledContainerColor
@Composable
fun SelectorCantidad(valor: Int, onChange: (Int) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = { onChange(valor - 1) }, enabled = valor > 1,
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF455A8A), disabledContainerColor = Color.LightGray)
        ) { Text("-") }
        Spacer(Modifier.width(12.dp))
        Text("$valor", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
        Spacer(Modifier.width(12.dp))
        Button(
            onClick = { onChange(valor + 1) }, enabled = valor < 10,
            shape = RoundedCornerShape(100),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF455A8A), disabledContainerColor = Color.LightGray)
        ) { Text("+") }
    }
}

// ---------- D) CAMPO CON FILTRO (stateless) ----------
// ETIQUETAS: campo con filtro, telefono, 9 digitos, solo numeros, placeholder, KeyboardType.Phone, stateless
@Composable
fun CampoTelefono(telefono: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = telefono,
        onValueChange = { if (it.all { c -> c.isDigit() } && it.length <= 9) onChange(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Teléfono") },
        placeholder = { Text("Ej: 600123123") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
    )
}

// ---------- E) CAMPO CONTRASEÑA (visibilidad dentro del hijo: permitido) ----------
// ETIQUETAS: contraseña, pin, mostrar ocultar, visibilidad dentro del hijo, rememberSaveable en hijo
@Composable
fun CampoPin(pin: String, onChange: (String) -> Unit) {
    var oculto by rememberSaveable { mutableStateOf(true) }
    OutlinedTextField(
        value = pin, onValueChange = onChange, modifier = Modifier.fillMaxWidth(),
        label = { Text("PIN") }, singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (oculto) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(if (oculto) "Mostrar" else "Ocultar",
                 modifier = Modifier.clickable { oculto = !oculto }.padding(end = 12.dp))
        }
    )
}

// ---------- F) LAYOUT ANIDADO: Column > Row(weights) > Spacer > Box centrado ----------
// ETIQUETAS: layout anidado, column row box, pesos 1f 2f, spacer 20dp, texto centrado, reto de layouts, estructura de pantalla
Column(modifier = modifier.fillMaxSize()) {
    Row(modifier = Modifier.fillMaxWidth().weight(1f)) {               // la Row reparte ALTO de la Column
        Box(Modifier.weight(1f).fillMaxHeight().background(Color.Red))   // 1/3 del ANCHO
        Box(Modifier.weight(2f).fillMaxHeight().background(Color.Yellow))// 2/3 del ANCHO
    }
    Spacer(Modifier.height(20.dp))
    Box(
        modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Green),
        contentAlignment = Alignment.Center
    ) { Text("Fin") }
}

// ---------- G) MAINACTIVITY CON SNACKBAR + PADDING ----------
// ETIQUETAS: mainactivity completa, scaffold con snackbar, innerPadding, llamar a la pantalla
setContent {
    MyApplicationTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
        ) { innerPadding ->
            FormularioScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

// ---------- H) LISTA QUE AÑADE/BORRA ELEMENTOS ----------
// ETIQUETAS: lista de tareas, añadir borrar, LazyColumn, mutableStateListOf, todo list, items
@Composable
fun ListaTareas(modifier: Modifier = Modifier) {
    var texto by rememberSaveable { mutableStateOf("") }
    val tareas = remember { mutableStateListOf<String>() }
    Column(modifier = modifier.padding(16.dp)) {
        Row {
            OutlinedTextField(value = texto, onValueChange = { texto = it }, modifier = Modifier.weight(1f))
            Button(onClick = { if (texto.isNotBlank()) { tareas.add(texto); texto = "" } }) { Text("+") }
        }
        LazyColumn {
            items(tareas) { tarea ->
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Text(tarea, modifier = Modifier.weight(1f))
                    TextButton(onClick = { tareas.remove(tarea) }) { Text("Borrar") }
                }
            }
        }
    }
}

// ---------- I) ESTADO COMPARTIDO ENTRE DOS HIJOS ----------
// ETIQUETAS: estado compartido, dos hijos, mismo contador, anti-patron, fuente unica
// Padre: var n by rememberSaveable { mutableIntStateOf(0) }
//        Hijo1(n) { n++ }   Hijo2(n) { n++ }     // ambos leen y modifican la MISMA variable
*/


/* =====================================================================
   13. ERRORES TÍPICOS / CHECKLIST
   ETIQUETAS: errores, fallos, checklist, no funciona, no sale, repaso final
   =====================================================================

// [ ] contentAlignment es SOLO de Box. Column: horizontalAlignment + verticalArrangement. Row: al revés.
// ETIQUETAS: errores, fallos, checklist, repasar antes de entregar, no funciona
// [ ] Column.horizontalAlignment pide Alignment.CenterHorizontally (no Alignment.Center)
// [ ] Raíz usa 'modifier'; hijos usan 'Modifier'. Si pones Modifier en la raíz, pierdes el innerPadding.
// [ ] Un composable sin = Modifier por defecto obliga a pasarlo siempre.
// [ ] weight solo funciona en hijo DIRECTO de Row/Column y el padre necesita tamaño (fillMaxSize...).
// [ ] Fondo que solo cubre la palabra: falta fillMaxWidth() en el Text.
// [ ] background antes de padding -> padding DENTRO del color; al revés -> FUERA.
// [ ] Variable normal (var n = 0) no refresca la UI: usa remember/rememberSaveable + mutableStateOf.
// [ ] mutableStateOf sin remember se reinicia en cada recomposición.
// [ ] remember se pierde al ROTAR; para conservar usa rememberSaveable.
// [ ] 'by' necesita var y los imports getValue y setValue.
// [ ] "${$n}" mal: es "$n" o "${n.value}". .value solo si NO usas 'by'.
// [ ] { x -> it } mal: si nombras el parámetro no hay 'it'.
// [ ] Lambda: onClick = onMenos (referencia) vs onClick = { onMenos() } (ambas valen).
// [ ] El Snackbar no sale sin snackbarHost en el Scaffold.
// [ ] showSnackbar es suspend: dentro de scope.launch { }.
// [ ] keyboardOptions no oculta texto; eso es visualTransformation.
// [ ] RoundedCornerShape(100) = porcentaje; RoundedCornerShape(100.dp) = radio fijo.
// [ ] El color del Text dentro de un Button gana al contentColor del Button.
// [ ] Preview: función SIN parámetros, con @Composable y @Preview.
// [ ] LazyColumn dentro de verticalScroll da error (dos scrolls infinitos).
// [ ] Composables en PascalCase (MiPantalla, no miPantalla).
// [ ] Hijos stateless: reciben valor + lambda, sin estado propio de datos compartidos.
*/
