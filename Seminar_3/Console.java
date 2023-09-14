package Seminar_3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Seminar_3.exception.DataSizeException;
import Seminar_3.exception.WrongDataException;



public class Console {
    final String[] KEY = {"Фамилия", "Имя", "Отчество", "Дата рождения", "Номер телефона", "Пол"};

    boolean work;
    Map<String, String> map;

    public Console() {
        this.work = true;
        this.map = new HashMap<>();
        this.fillingMapKey();
    }

    private void fillingMapKey() {
        for (String string : KEY) {
            this.map.put(string, null);
        }
    }

    public void start() {
        while (work) {
            String[] data = getDataConsole();
            try {
                if (checkDataSize(data)) {
                    parseDataToMap(data);
                    if (checkValideData(this.map)) {
                        writeToFile(this.map);
                        this.work = false;
                    }
                }
            } catch (DataSizeException | WrongDataException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeToFile(Map<String, String> map) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("S\\" + map.get(KEY[0]).toLowerCase() + ".txt", true))) {
            bufferedWriter.write(map.toString());
            bufferedWriter.newLine();
        }
    }

    private boolean checkValideData(Map<String, String> map) throws WrongDataException {
        if (!map.get(KEY[0]).matches("^[a-zA-Zа-яА-Я]*$")){
            throw new WrongDataException("Фамилия введена неверно.");
        }
        if (!map.get(KEY[1]).matches("^[a-zA-Zа-яА-Я]*$")){
            throw new WrongDataException("Имя введено неверно.");
        }
        if (!map.get(KEY[2]).matches("^[a-zA-Zа-яА-Я]*$")){
            throw new WrongDataException("Отчество введено неверно.");
        }

        try {
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(map.get(KEY[3]), DateTimeFormatter.ofPattern("dd.MM.uuuu"));
            if (date.isAfter(now)) {
                throw new WrongDataException("Дата указана неверно.");
            }
        } catch (DateTimeParseException e) {
            throw new WrongDataException("Дата была указана в неверном формате.");
        }

        if (map.get(KEY[4]).length() != 11 || !map.get(KEY[4]).matches("^[0-9]*$")){
            throw new WrongDataException("Телефон введен неверно.");
        }
        System.out.println(map.get(KEY[5]));
        if (!map.get(KEY[5]).equalsIgnoreCase("f") && !map.get(KEY[5]).equalsIgnoreCase("m")){
            throw new WrongDataException("Неверно указан пол.");
        }

        return true;
    }

    private boolean checkDataSize(String[] data) throws DataSizeException {
        if (data.length != KEY.length) {
            throw new DataSizeException(data.length > KEY.length ? "Вы ввели много данных." : "Вы ввели мало данных.");
        }
        return true;
    }

    private void parseDataToMap(String[] data) {
        for (int i = 0; i < data.length; i++) {
            this.map.put(KEY[i], data[i]);
        }
    }

    private String[] getDataConsole() {
        String[] temp;
        System.out.println("Введите данные в формате:");
        System.out.println("<Фамилия> <Имя> <Отчество> <дата рождения \"dd.mm.yy\"> <номер телефона \"8**********\"> <пол \"f\"/\"m\")>");
        Scanner scanner = new Scanner(System.in, "UTF-8");
        temp = scanner.nextLine().split(" ");
        return temp;
    }
}
