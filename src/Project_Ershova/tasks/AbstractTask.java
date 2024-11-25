package Project_Ershova.tasks;

public abstract class AbstractTask implements RunnableTask, Comparable<AbstractTask>, Cloneable {
    private String name;

    public AbstractTask(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(AbstractTask other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public AbstractTask clone() {
        try {
            return (AbstractTask) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Ошибка клонирования задачи", e);
        }
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractTask task = (AbstractTask) obj;
        return name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
