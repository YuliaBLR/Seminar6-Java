import java.util.*;


class MyPhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    // Метод добавления новой записи в справочник (если в справочнике уже есть такое имя,
    // то в запись добавляется еще один номер телефона при условии, что такой номер уже не записан
    public void add(String Name, Integer PhoneNum) {

        int count = 0;
        if (phoneBook.containsKey(Name)) {
            for (int values : phoneBook.get(Name)) {
                if (values == PhoneNum) {
                    count = 1;
                }
            }
            if (count == 0) {
                phoneBook.get(Name).add(PhoneNum);
                System.out.println("Номер добавлен");
            } else {
                System.out.println("Данные уже внесены");
            }

        } else {
            ArrayList<Integer> Value = new ArrayList<>();
            Value.add(PhoneNum);
            phoneBook.put(Name, Value);
            System.out.println("Запись добавлена");
        }
    }

    // Метод для вывода всего справочника в консоль (неотсортированного)
    public void print() {
        phoneBook.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    // Метод для вывода всего справочника в консоль (отсортированного по убыванию количества телефонов)
    public void sortprint() {

        Comparator<ArrayList<Integer>> comp = new Comparator<>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        };
        phoneBook.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(comp))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    // Метод для поиска номеров телефона по имени
    public void search(String Name) {
        if (phoneBook.containsKey(Name)) {
            System.out.println(Name + ": " + phoneBook.get(Name));
        } else {
            System.out.println("Данное имя отсутствует в справочнике");
        }

    }

    // Метод удаления записи по имени
    public void deletingName(String Name) {
        phoneBook.remove(Name);
    }

    // Метод удаления номера телефона из записи по имени и номеру
    public void delphonenum(String Name, Integer PhoneNum) {
        int count = 0;
        if (phoneBook.containsKey(Name)) {
            for (int value : phoneBook.get(Name)) {
                if (value == PhoneNum) {
                    phoneBook.get(Name).remove(PhoneNum);
                    System.out.println("Номер телефона удален");
                } else {
                    System.out.println("Введенного номера нет у пользователя " + Name);
                }
            }
        } else {
            System.out.println("Данное имя отсутствует в справочнике");

        }
    }


    // Метод для чтения ввода варианта в консоль
    public int scanner() {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Выберите вариант действий:");
        int variant = iScanner.nextInt();
        if (iScanner.hasNext()) {
            return variant;
        } else {
            return 0;
        }

    }

    // Вывод вариантов действий
    public void varprint(){
        System.out.println("1. Вывод справочника (неотсортированный вид)");
        System.out.println("2. Вывод справочника (вид, отсортированный по убыванию количества телефонов");
        System.out.println("3. Поиск записи по имени");
        System.out.println("4. Добавление новой записи в справочник");
        System.out.println("5. Удаление записи по имени");
        System.out.println("6. Удаление номера телефона из записи");
        System.out.println("7. Выход");
    }

}

    public class ZadachaItog {
        public static void main(String[] args) {

            MyPhoneBook PB = new MyPhoneBook();

            String name1 = "Ivanov";
            String name2 = "Petrov";
            String name3 = "Potter";
            int phone1 = 123456;
            int phone2 = 654321;
            int phone3 = 655951;
            int phone4 = 448551;
            int phone5 = 256633;
            int phone6 = 456236;
            int phone7 = 844562;
            PB.add(name1, phone1);
            PB.add(name1, phone2);
            PB.add(name2, phone2);
            PB.add(name2, phone3);
            PB.add(name2, phone4);
            PB.add(name3, phone6);



            int var = 0;

            while (var == 0){
                PB.varprint();
                Scanner iScanner = new Scanner(System.in);
                System.out.println("Выберите вариант действий:");
                var = iScanner.nextInt();
                while (var == 1 | var ==2 | var ==3 | var ==4 | var ==5 | var ==6 | var ==7){
                    switch (var){
                        case 1:
                            PB.print();
                            var = 0;
                            break;
                        case 2:
                            PB.sortprint();
                            var = 0;
                            break;
                        case 3:
                            Scanner sc3 = new Scanner(System.in);
                            System.out.print("Введите имя: ");
                            String name_3 = sc3.nextLine();
                            PB.search(name_3);
                            var = 0;
                            break;
                        case 4:
                            Scanner sc4 = new Scanner(System.in);
                            System.out.print("Введите имя: ");
                            String name_4 = sc4.nextLine();
                            Scanner sc41 = new Scanner(System.in);
                            System.out.print("Введите номер телефона: ");
                            int phoneNum4 = sc41.nextInt();
                            PB.add(name_4, phoneNum4);
                            var = 0;
                            break;
                        case 5:
                            Scanner sc5 = new Scanner(System.in);
                            System.out.print("Введите имя: ");
                            String name_5 = sc5.nextLine();
                            PB.deletingName(name_5);
                            var = 0;
                            break;
                        case 6:
                            Scanner sc6 = new Scanner(System.in);
                            System.out.print("Введите имя: ");
                            String name_6 = sc6.nextLine();
                            PB.search(name_6);
                            System.out.print("Введите номер для удаления: ");
                            int phoneNum_6 = sc6.nextInt();
                            PB.delphonenum(name_6, phoneNum_6);
                            var = 0;
                            break;
                        case 7:
                            System.out.println("Всего доброго!");
                            var = -1;
                            break;
                    }
                }
            }
        }
    }

