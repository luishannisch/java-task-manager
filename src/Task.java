
public class Task {
    private String description;
    private int priority;
    private boolean completed;

    public Task(String description, int priority){
        this.description = description;
        this.priority = priority;
        this.completed = false;
    }

    //GETTERS
    public String getDescription(){
        return description;
    }

    public int getPriority(){
        return priority;
    }

    public void completeTask(){
        completed = true;
    }

    @Override
    public String toString(){

        String status;

        if (completed){
            status = "[✔]";
        } else {
            status = "[ ]";
        }

        return status + " " + description + " | prioridade: " + priority;
    }

    //SETTERS
    public void setDescription(String description){
        this.description = description;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setPriority(int priority){
        if(priority >= 1 && priority <= 10){
            this.priority = priority;
        }
    }
}
