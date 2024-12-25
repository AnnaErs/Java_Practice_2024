package Project_Ershova.tasks;

public class DeveloperInfoTask extends Task {
    private String info;

    public DeveloperInfoTask(String name, String info) {
        super(name);
        this.info = info;
    }

    @Override
    public void execute() {
        System.out.println(info);
    }
}

