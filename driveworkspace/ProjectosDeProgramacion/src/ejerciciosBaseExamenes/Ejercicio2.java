package ejerciciosBaseExamenes;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String curso;
		int numAlum;
		int cursMen8Alum = 0;
		int medNotas = 0;
		String curMayorMed = "???";
		int medMejorCur = Integer.MIN_VALUE;
		String curMenMed = "???";
		int medPeorCur = Integer.MAX_VALUE;
		String curMasSusp = "???";
		int suspPeorCur = Integer.MIN_VALUE;
		String segCurcMasSusp = "???";
		int suspSegPeorCur = Integer.MIN_VALUE;
		int curMen2Susp = 0;
		String mejorCur = "???";
		int aprMejorCur = 0;
		int ultNota = 0;
		int penultNota = 0;
		System.out.println("Introduce el curso al que quieres evaluar");
		curso = sc.next();

		while (!curso.equals("fin")) {
			System.out.println("Cuantos alumnos tiene dicho curso");
			numAlum = sc.nextInt();
			int sumanotas = 0;
			int nota;
			int suspensos = 0;
			int aprobados = 0;
			for (int alumnoaEvaluar = 1; alumnoaEvaluar <= numAlum; alumnoaEvaluar++) {
				System.out.println("Introduzca la nota del alumno " + alumnoaEvaluar);
				nota = sc.nextInt();
				penultNota = ultNota;
				ultNota = nota;
				sumanotas = sumanotas + nota;
				if (nota < 5) {
					suspensos++;
				} else {
					aprobados++;
				}
			}
			if (numAlum < 8) {
				cursMen8Alum++;
			}
			if (numAlum > 5 && aprobados > aprMejorCur) {
				mejorCur = curso;
				aprMejorCur = aprobados;
			}
			if (suspensos < 2) {
				curMen2Susp++;
			}
			if (suspensos > suspPeorCur) {
				segCurcMasSusp = curMasSusp;
				suspSegPeorCur = suspPeorCur;
				curMasSusp = curso;
				suspPeorCur = suspensos;
			} else if (suspensos > suspSegPeorCur) {
				segCurcMasSusp = curso;
				suspSegPeorCur = suspensos;
			}
			medNotas = (sumanotas / numAlum);
			if (medNotas > medMejorCur) {
				curMayorMed = curso;
				medMejorCur = medNotas;
			}
			if (medNotas < medPeorCur) {
				curMenMed = curso;
				medPeorCur = medNotas;
			}
			System.out.println("La media aritmetica del curso " + curso + " es " + medNotas);
			System.out.println("Introduce el nombre de otro curso");
			curso = sc.next();
		}
		System.out.println("El numero de clases con menos de 8 alumnos es " + cursMen8Alum
				+ " El curso con mayor media es " + curMayorMed + " El curso con menor media es " + curMenMed
				+ " Los dos cursos con mayor numero de suspensos son " + curMasSusp + " y el segundo " + segCurcMasSusp
				+ " El numero de cursos con menos de dos suspensos es " + curMen2Susp
				+ " El curso con mas de 5 alumnos con mayor numero de aprobados es " + mejorCur
				+ " Las dos ultimas notas son " + ultNota + " Y la penultima es " + penultNota);
		sc.close();
	}

}
