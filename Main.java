import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void addTask(Scanner scanner, ArrayList<Task> tasks) {
        System.out.println("Descrição da tarefa:");
        String description = scanner.nextLine();

        int priority;

        while (true) {
            System.out.println("Prioridade da tarefa (1 - 10):");

            try {

                priority = scanner.nextInt();
                scanner.nextLine();

                if (priority < 1 || priority > 10) {
                    System.out.println("Digite um número entre 1 e 10.");
                    continue;
                }

                break;

            } catch (Exception e) {

                System.out.println("Digite apenas números.");
                scanner.nextLine(); // limpa entrada inválida
            }
        }

        Task task = new Task(description, priority);
        tasks.add(task);

        System.out.println("Tarefa adicionada!");
    }

    public static void listTasks(ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada!");
        }
        else{
            for (int i = 0; i < tasks.size(); i++){
                System.out.println(i + " - " + tasks.get(i));
            }
        }
    }

    public static void completeTask(Scanner scanner, ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada!");
        }
        else {
            System.out.println("\nTarefas cadastradas:");
            listTasks(tasks);

            while (true){
                System.out.println("Digite o número da tarefa que deseja concluir:");

                try {
                    int completedTask = scanner.nextInt();
                    scanner.nextLine();

                    if (completedTask < 0 || completedTask >= tasks.size()){
                        System.out.println("Número não existe ou inválido! Digite novamente.");
                        continue;
                    }

                    tasks.get(completedTask).completeTask();
                    System.out.println("Tarefa concluída!");
                    break;

                } catch (Exception e){
                    System.out.println("Digite apenas números válidos.");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void removeTask(Scanner scanner, ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada!");
        }
        else {
            System.out.println("\nTarefas cadastradas:");
            listTasks(tasks);

            while (true){
                System.out.println("Digite o número da tarefa que deseja remover:");

                try {
                    int deletedTask = scanner.nextInt();
                    scanner.nextLine();

                    if (deletedTask < 0 || deletedTask >= tasks.size()){
                        System.out.println("Número não existe ou inválido! Digite novamente.");
                        continue;
                    }

                    tasks.remove(deletedTask);
                    System.out.println("Tarefa removida!");
                    break;

                } catch (Exception e){
                    System.out.println("Digite apenas números válidos.");
                    scanner.nextLine();
                }
            }
        }
    }

    public static void listTasksByPriority(ArrayList<Task> tasks){
        if (tasks.isEmpty()){
            System.out.println("Nenhuma tarefa cadastrada!");
        }
        else{
            ArrayList<Task> sortedTasks = new ArrayList<>(tasks);
            sortedTasks.sort((a, b) -> b.getPriority() - a.getPriority());

            System.out.println("\nTarefas ordenadas por prioridade:");
            for (int i = 0; i < sortedTasks.size(); i++){
                System.out.println(i + " - " + sortedTasks.get(i));
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {

            int option;

            while (true) {

                System.out.println("\nDigite o número da opção:");
                System.out.println("\n1 - Adicionar tarefa");
                System.out.println("2 - Listar tarefas");
                System.out.println("3 - Concluir tarefa");
                System.out.println("4 - Remover tarefa");
                System.out.println("5 - Listar tarefas por prioridade");
                System.out.println("0 - Sair");

                try {

                    option = scanner.nextInt();
                    scanner.nextLine();

                    if (option < 0 || option > 5) {
                        System.out.println("Opção inválida! Digite novamente.");
                        continue;
                    }

                    break;

                } catch (Exception e) {

                    System.out.println("Digite apenas números!");
                    scanner.nextLine(); // limpa entrada inválida

                }
            }

            switch (option) {

                case 0:
                    System.out.println("Encerrando programa...");
                    scanner.close();
                    return;

                case 1:
                    addTask(scanner, tasks);
                    break;

                case 2:
                    listTasks(tasks);
                    break;

                case 3:
                    completeTask(scanner, tasks);
                    break;

                case 4:
                    removeTask(scanner, tasks);
                    break;

                case 5:
                    listTasksByPriority(tasks);
                    break;
            }
        }
    }
}