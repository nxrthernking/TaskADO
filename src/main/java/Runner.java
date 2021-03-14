import entities.User;
import repositories.Repository;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] arg) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Repository repository = RepositoryFactory.getRepositoryFromFactory("USER_DB");
        MenuUserDb(scanner,repository);
    }

    private static void MenuUserDb(Scanner scanner, Repository<User,Long> repository){
        int choice = 0;
        System.out.println("1) Добавить пользователя");
        System.out.println("2) Найти пользователя");
        System.out.println("3) Удалить пользователя");
        System.out.println("4) Найти всех пользователей");
        System.out.println("5) Выход");
        while(choice != -1){
            System.out.print("Выберете пункт: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    User user = new User();
                    System.out.print("Введите имя пользователя: ");
                    user.setUsername(scanner.next());
                    System.out.print("Введите пароль: ");
                    user.setPassword(scanner.next());
                    repository.save(user);
                    break;
                case 2:
                    System.out.print("Введите id пользователя: ");
                    long id = scanner.nextLong();
                    System.out.println(repository.findById(id));
                    break;
                case 3:
                    System.out.print("Введите id пользователя: ");
                     id = scanner.nextLong();
                     repository.remove(id);
                    System.out.println("Пользователь удален!");
                    break;
                case 4:
                    System.out.println(repository.findAll());
                    break;
                case 5:
                    choice = -1;
                    break;
            }

        }

    }
}
