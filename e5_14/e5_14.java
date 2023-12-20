package e5_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class e5_14 {

    private static final String file_name = "e5_14/input.txt";

    public static void main(String[] args) {
        Set<String> brands = get_car_brands();

        System.out.println("a) Owners by brand:");
        for (String brand : brands) {
            owners_by_brand(brand);
        }
        System.out.print("\n");
        System.out.println("b) Numbers by brand:");
        for (String brand : brands) {
            car_numbers_by_brand(brand);
        }
        System.out.print("\n");
        System.out.println("c) Count by brand:");
        for (String brand : brands) {
            car_count_by_brand(brand);
        }
    }

    public static Set<String> get_car_brands() {
        Set<String> brands = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] components = str.split(" ");
                String current_brand = components[0];
                brands.add(current_brand);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brands;
    }

    public static void owners_by_brand(String brand) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name))) {
            String str;
            StringBuilder owners = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                String[] components = str.split(" ");
                String current_brand = components[0];
                String owner_lastname = components[2];

                if (current_brand.equals(brand)) {
                    if (owners.length() > 0) {
                        owners.append(", ");
                    }
                    owners.append(owner_lastname);
                }
            }
            System.out.println(brand + ": " + owners.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void car_count_by_brand(String brand) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name))) {
            String str;
            int count = 0;
            while ((str = reader.readLine()) != null) {
                String[] components = str.split(" ");
                String currentBrand = components[0];

                if (currentBrand.equals(brand)) {
                    count++;
                }
            }
            System.out.println(brand + ": " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void car_numbers_by_brand(String brand) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file_name))) {
            String str;
            StringBuilder car_numbers = new StringBuilder();
            while ((str = reader.readLine()) != null) {
                String[] components = str.split(" ");
                String current_brand = components[0];
                String car_number = components[1];

                if (current_brand.equals(brand)) {
                    if (car_numbers.length() > 0) {
                        car_numbers.append(", ");
                    }
                    car_numbers.append(car_number);
                }
            }
            System.out.println(brand + ": " + car_numbers.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
