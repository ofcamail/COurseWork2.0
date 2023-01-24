package services;
import exceptions.TaskNotFoundExceptions;
import task.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class TaskService {
    private final Map<Integer, Task> taskMap;
    private final Collection<Task> removedTasks;
    public TaskService() {
        this.taskMap = new HashMap<>();
        this.removedTasks = new ArrayList<>();
    }


    public void add(Task task) {
        taskMap.put(task.getId(), task);
    }

    public Task remove (int id){
        if (taskMap.containsKey(id)) {
            Task someTask = taskMap.get(id);
            removedTasks.add(someTask);
            taskMap.remove(id);
            return someTask;
        } else {
            throw new TaskNotFoundExceptions();
        }
    }

    public Collection<Task> getAllByDate(LocalDate localDate) {
        return taskMap.values().stream().filter(task -> task.appearsIn(localDate)).collect(Collectors.toList());
    }
}