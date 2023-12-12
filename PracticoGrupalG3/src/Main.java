import java.util.*;

//*VERSION 9

//*-------------------------Alumnos-------------------------------------------
//*Erica Nathalia Nasra // *Nelio Bazan  // *Fernando Iglesias
//*Mansilla Sara //*Fernando Serrano // *Miguel Marchione //*Evelyn Pini
//*Sergio Peluffo // *Bulich Canelo Agustina // *Mauro Cardin //
//**---------------------------------------------------------------------

public class Main {
    String nombre;
    public static void main(String[] args) throws InputMismatchException {
        Scanner sele = new Scanner(System.in);
        HashSet<String> nombres = new HashSet<String>();
        HashMap<String, HashMap<String, Integer>> alumnosNotas = new HashMap<>();
        String eleccionContinuar;

        ArrayList<String> materias = new ArrayList<String>();
        materias.add("Teleinformatica"); //sacamos todo esto del caso 5 para que no rompa el caso 6
        materias.add("Programación web");
        materias.add("Arquitectura del computador");
        materias.add("Diseño y administración de base de datos");
        materias.add("Inteligencia Artificial");

        ArrayList<String> materiasHora = new ArrayList<String>();
        materiasHora.add("Teleinformatica - Lunes 19 a 22 horas "); //sacamos todo esto del caso 5 para que no rompa el caso 6
        materiasHora.add("Programación web - Martes 19 a 22 horas ");
        materiasHora.add("Arquitectura del computador - Miércoles 19 a 22 horas ");
        materiasHora.add("Diseño y administración de base de datos - Jueves 19 a 22 horas ");
        materiasHora.add("Inteligencia Artificial - Viernes 19 a 22 horas.");

        ArrayList<String> docentes = new ArrayList<String>();
        docentes.add("Prof. Mabel Escobar Korajay"); //sacamos todo esto del caso 4
        docentes.add("Dibu Martinez");
        docentes.add("Papu Gomez");
        docentes.add("Leandro Paredes");
        docentes.add("Enzo Fernandez");


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("               Instituto Herman Hollerith");
        System.out.println("                   Moron, Buenos Aires");
        System.out.println("------------------version 9.0 2023-11-12-----------------");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        do {
            System.out.println("Elija una de las opciones:");
            System.out.println("1- Ingresar alumnos ");
            System.out.println("2- Modificación de alumno cargado");
            System.out.println("3- Borrar alumno");
            System.out.println("4- Listar profesores");
            System.out.println("5- Listar materias y horarios");
            System.out.println("6- Cargar las notas de las materias");
            System.out.println("7- Lista de alumnos");
            System.out.println("8- Lista de alumnos con materias, notas y estado de aprobación");

            int opcion = sele.nextInt();
            sele.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    System.out.println("Escriba el nombre del alumno: ");
                    String a = sele.nextLine();
                    nombres.add(a);
                    String b;
                    System.out.println("¿Quiere seguir cargando? s/n");
                    do {
                        b = sele.nextLine().toLowerCase();
                        if (!b.equals("s") && !b.equals("n")) {
                            System.out.println("Ingrese una opción válida (s/n): ");
                        }
                    } while (!b.equals("s") && !b.equals("n"));
                    while ("s".equalsIgnoreCase(b)) {
                        System.out.println("Escriba el nombre del alumno: ");
                        a = sele.nextLine();
                        nombres.add(a);
                        System.out.println("¿Quiere seguir cargando? s/n");
                        do {
                            b = sele.nextLine().toLowerCase();
                            if (!b.equals("s") && !b.equals("n")) {
                                System.out.println("Ingrese una opción válida (s/n): ");
                            }
                        } while (!b.equals("s") && !b.equals("n"));
                    }

                    System.out.println("La lista de alumnos es: " + nombres);
                    break;

                case 2:
                    System.out.println("La lista de alumnos a modificar es : " + nombres);
                    System.out.println("Ingrese el nombre del alumno que desea modificar: ");
                    String nombreModificar = sele.nextLine();

                    if (nombres.contains(nombreModificar)) {
                        nombres.remove(nombreModificar);

                        System.out.println("Ingrese el nuevo nombre para el alumno: ");
                        String nuevoNombre = sele.nextLine();
                        nombres.add(nuevoNombre);

                        System.out.println("Alumno modificado. La lista de alumnos es: " + nombres);
                    } else {
                        System.out.println("El alumno no se encuentra en la lista.");
                    }

                    break;

                case 3:
                    System.out.println("Lista de alumnos: " + nombres);

                    System.out.print("Ingresa el nombre del alumno que desea eliminar: ");
                    String nombreAEliminar = sele.nextLine();

                    if (nombres.contains(nombreAEliminar)) {
                        nombres.remove(nombreAEliminar);
                        System.out.println(nombreAEliminar + " ha sido eliminado de la lista.");
                    } else {
                        System.out.println("Error: el nombre no existe en la lista.");
                    }

                    System.out.println("Lista de estudiantes actualizada: " + nombres);
                    break;

                case 4:


                    System.out.println("Lista de profesores: " + docentes);
                    break;

                case 5:

                    System.out.println("Lista de materias y horarios: " + materiasHora);

                    break;

                case 6:
                    System.out.println("La lista de materias es " + materias);
                    System.out.println("Lista de estudiantes actualizada: " + nombres);
                    int notas;
                    int[] nota = new int[5];
                    nota = new int[5];

                    System.out.println("Ingrese Nombre del Alumno: ");
                    String nombreAlumno = sele.nextLine();

                    HashMap<String, Integer> notasMaterias = new HashMap<>();

                    for (int i = 0; i < 5; i++) {
                        do {
                            try {
                                System.out.println("Ingrese la nota de " + materias.get(i) + ": ");
                                notas = sele.nextInt();
                                if (notas < 0 || notas > 10) {
                                    throw new InputMismatchException("La nota debe estar entre 0 y 10.");
                                }
                                nota[i] = notas;
                            } catch (InputMismatchException e) {
                                System.out.println("Error: Ingrese una nota válida entre 0 y 10.");
                                sele.nextLine(); // Limpiar el buffer del scanner
                            }
                        } while (nota[i] < 0 || nota[i] > 10); // Repetir hasta que se ingrese una nota válida

                        notasMaterias.put(materias.get(i), nota[i]);
                    }


                    alumnosNotas.put(nombreAlumno, notasMaterias);

                    System.out.println("Notas registradas para el alumno: " + nombreAlumno);
                    System.out.println(notasMaterias);

                    b = sele.nextLine();
                    break;

                case 7:
                    System.out.println("Lista de alumnos:");
                    for (String alumno : nombres) {
                        System.out.println(alumno);
                    }
                    break;

                case 8:
                    System.out.println("Lista de alumnos con materias, notas y estado de aprobación:");
                    for (Map.Entry<String, HashMap<String, Integer>> entry : alumnosNotas.entrySet()) {
                        System.out.println("Alumno: " + entry.getKey());
                        HashMap<String, Integer> notasMateriasEntry = entry.getValue();

                        for (Map.Entry<String, Integer> notaEntry : notasMateriasEntry.entrySet()) {
                            if (notaEntry.getValue() >= 7)
                                System.out.println("Materia: " + notaEntry.getKey() + ". Nota " + notaEntry.getValue() + ".APROBADO.");
                            else
                                System.out.println("Materia: " + notaEntry.getKey() + ". Nota " + notaEntry.getValue() + (notaEntry.getValue() < 4 ? ".REPROBADO" : ".A FINAL"));
                        }
                    }
                    break;

                default:
                    System.out.println("Elija una nueva opcion");
                    break;
            }

            System.out.println("¿Desea continuar en el programa? s/n");
            eleccionContinuar = sele.nextLine().toLowerCase();
            while (!eleccionContinuar.equals("s") && !eleccionContinuar.equals("n")) {
                System.out.println("Ingrese una opción válida (s/n): ");
                eleccionContinuar = sele.nextLine().toLowerCase();
            }
        } while ("s".equals(eleccionContinuar));
        System.out.println("El programa ha sido cerrado");
    }
}