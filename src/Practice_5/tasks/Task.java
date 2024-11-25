package Practice_5.tasks;

//Базовый класс Task

public abstract class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return "Task{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return name.equals(task.name);
    }
}

