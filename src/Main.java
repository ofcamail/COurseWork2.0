import enums.Type;
import exceptions.TaskNotFoundExceptions;
import services.TaskService;
import task.DailyTask;
import task.OneTimeTask;
import task.WeeklyTask;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        DailyTask dailyTask = new DailyTask(
                "Задание дня",
                Type.WORK,
                "Работай, Лена, солнце еще высоко",
                LocalDateTime.of(2023,2,1,8,0)
        );
        WeeklyTask weeklyTask = new WeeklyTask(
                "Задание недели",
                Type.PERSONAL,
                "покорми кота",
                LocalDateTime.of(2023,1,1,1,5)
        );

        OneTimeTask oneTimeTask = new OneTimeTask(
                "Одноразовое мероприятие",
                Type.PERSONAL,
                "покорми себя",
                LocalDateTime.of(2023,1,1,9,5)
        );
        TaskService taskService = new TaskService();
        taskService.add(dailyTask);
        taskService.add(oneTimeTask);
        taskService.add(weeklyTask);

        System.out.println(taskService.getAllByDate(LocalDate.of(2023, 2, 2)));
    }
}