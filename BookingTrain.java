package PlanMyJourney;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Objects;

import java.util.Scanner;

class Train {
    String TrainName;
    int TrainNumber;
    String to;
    String fro;
    int ReservedSeats;
    int ACSeats;
    int NonACSeats;
    float ReservedCost;
    float ACCost;
    float NonACCost;
    float Tax;
    float foodCost;
    float insurance;

    Train(String TrainName,int TrainNumber,String fro,String to,int ReservedSeats,int ACSeats,int NonACSeats,float ReservedCost,float ACCost,float NonACCost,float Tax,float foodCost,float insurance){
        this.TrainName = TrainName;
        this.TrainNumber = TrainNumber;
        this.to = to;
        this.fro = fro;
        this.ReservedSeats = ReservedSeats;
        this.ACSeats = ACSeats;
        this.NonACSeats = NonACSeats;
        this.ReservedCost = ReservedCost;
        this.ACCost = ACCost;
        this.NonACCost = NonACCost;
        this.Tax = Tax;
        this.foodCost = foodCost;
        this.insurance = insurance;
    }
}


public class BookingTrain{
    public static void main(String[] args) throws IOException {
        Scanner getInput = new Scanner(System.in);
        BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));
        Train[] details = {
                new Train("AAA", 1, "Chennai", "Bangalore", 5, 10, 10, 550, 380, 210, 3, 100, 15),
                new Train("BBB", 2, "Chennai", "Delhi", 5, 10, 10, 550, 380, 210, 3, 100, 15),
                new Train("CCC", 3, "Delhi", "Chennai", 5, 10, 10, 550, 380, 210, 3, 100, 15),
                new Train("DDD", 4, "Bangalore", "Chennai", 5, 10, 10, 550, 380, 210, 3, 100, 15),
                new Train("EEE", 5, "Chennai", "Mumbai", 5, 10, 10, 550, 380, 210, 3, 100, 15),
        };
        System.out.println("Train Details : ");
        for (int i = 0; i < details.length; i++) {
            System.out.println(details[i].TrainNumber + " " + details[i].TrainName + " " + details[i].fro + " " + details[i].to);
        }
        System.out.println();
        System.out.println("Enter the number of Bookings : ");
        int a = getInput.nextInt();
        for(int j=0; j<a; j++){
            System.out.println("Enter the name : ");
            String name = Input.readLine();
            System.out.println("Enter the Train Number : ");
            int b = getInput.nextInt();
            for(int k=0; k<details.length; k++){
                if(b==details[k].TrainNumber){
                    System.out.println("Enter the Coach (Reserved/Ac/NonAc) : ");
                    String Coach = Input.readLine();
                    switch (Coach) {
                        case "Reserved" -> {
                            ArrayList<Float> RTotalCost = new ArrayList<>();
                            System.out.println("Maximum Seats allowed 5");
                            System.out.println("Enter the total tickets : ");
                            int t = getInput.nextInt();
                            if (t <= 5) {
                                float Rate1 = (t * details[k].ReservedCost) + (t * (details[k].Tax / 100) * details[k].ReservedCost);
                                RTotalCost.add(Rate1);
                                System.out.println("Food (Yes/No) : ");
                                String f = Input.readLine();
                                int TP1 = 0;
                                if (Objects.equals(f, "Yes")) {
                                    System.out.println("Enter the number of food packs : ");
                                    int fp = getInput.nextInt();
                                    TP1 = fp;
                                    float Cost1 = fp * details[k].foodCost;
                                    RTotalCost.add(Cost1);
                                }
                                System.out.println("Insurance (Yes/No) : ");
                                String I = Input.readLine();
                                int IP1 = 0;
                                if (Objects.equals(I, "Yes")) {
                                    System.out.println("Enter the number of passengers : ");
                                    int pi = getInput.nextInt();
                                    IP1 = pi;
                                    if (pi <= t) {
                                        float Cost2 = pi * details[k].insurance;
                                        RTotalCost.add(Cost2);
                                    } else {
                                        System.out.println("Maximum passengers reached !\n");
                                    }
                                }
                                float TotalCost1 = 0;
                                for (int l = 0; l < RTotalCost.size(); l++) {
                                    TotalCost1 += RTotalCost.get(l);
                                }
                                System.out.println("\nName : " + name);
                                System.out.println("Train Details : " + b + " " + details[k].TrainName + " " + details[k].fro + " " + details[k].to);
                                System.out.println("Coach : " + Coach);
                                System.out.println("Total Tickets : " + t);
                                if (f.equals("Yes")){
                                    System.out.println("Food : " + f + " (" + TP1 + ")");
                                } else if (f.equals("No")) {
                                    System.out.println("Insurance : " + f);
                                } else {
                                    System.out.println("Food : " + "-");
                                }
                                if (I.equals("Yes")) {
                                    System.out.println("Insurance : " + I + " (" + IP1 + ")");
                                } else if (I.equals("No")) {
                                    System.out.println("Insurance : " + I);
                                } else {
                                    System.out.println("Insurance : " + "-");
                                }
                                System.out.println("Total Cost : " + TotalCost1 + "\n");

                            } else {
                                System.out.println("Maximum Seats Reached !\n");
                            }
                        }

                        case "Ac" -> {
                            ArrayList<Float> ATotalCost = new ArrayList<>();
                            System.out.println("Maximum Seats allowed 10");
                            System.out.println("Enter the total tickets : ");
                            int v = getInput.nextInt();
                            if (v <= 10) {
                                float Rate2 = (v * details[k].ACCost) + (v * (details[k].Tax / 100) * details[k].ACCost);
                                ATotalCost.add(Rate2);
                                System.out.println("Food (Yes/No) : ");
                                String o = Input.readLine();
                                int TP2 = 0;
                                if (Objects.equals(o, "Yes")) {
                                    System.out.println("Enter the number of food packs : ");
                                    int op = getInput.nextInt();
                                    TP2 = op;
                                    float Cost3 = op * details[k].foodCost;
                                    ATotalCost.add(Cost3);
                                }
                                System.out.println("Insurance (Yes/No) : ");
                                String s = Input.readLine();
                                int IP2 = 0;
                                if (Objects.equals(s, "Yes")) {
                                    System.out.println("Enter the number of passengers : ");
                                    int si = getInput.nextInt();
                                    IP2 = si;
                                    if (v >= si) {
                                        float Cost4 = si * details[k].insurance;
                                        ATotalCost.add(Cost4);
                                    } else {
                                        System.out.println("Maximum passengers reached !\n");
                                    }
                                }
                                float TotalCost2 = 0;
                                for (int h = 0; h < ATotalCost.size(); h++) {
                                    TotalCost2 += ATotalCost.get(h);
                                }
                                System.out.println("\nName : " + name);
                                System.out.println("Train Details : " + b + " " + details[k].TrainName + " " + details[k].fro + " " + details[k].to);
                                System.out.println("Coach : " + Coach);
                                System.out.println("Total Tickets : " + v);
                                if (o.equals("Yes")) {
                                    System.out.println("Food : " + o + " (" + TP2 + ")");
                                } else if (o.equals("No")) {
                                    System.out.println("Food : " + o);
                                } else {
                                    System.out.println("Food : " + "-");
                                }
                                if (s.equals("Yes")) {
                                    System.out.println("Insurance : " + s + " (" + IP2 + ")");
                                } else if (s.equals("No")) {
                                    System.out.println("Insurance : " + s);
                                } else {
                                    System.out.println("Insurance : " + "-");
                                }
                                System.out.println("Total Cost : " + TotalCost2 + "\n");
                            } else {
                                System.out.println("Maximum Seats Reached !\n");
                            }
                        }

                        case "NonAc" -> {
                            ArrayList<Float> NTotalCost = new ArrayList<>();
                            System.out.println("Maximum Seats allowed 10");
                            System.out.println("Enter the total tickets : ");
                            int w = getInput.nextInt();
                            if (w <= 10) {
                                float Rate3 = (w * details[k].NonACCost) + (w * (details[k].Tax / 100) * details[k].NonACCost);
                                NTotalCost.add(Rate3);
                                System.out.println("Food (Yes/No) : ");
                                String q = Input.readLine();
                                int TP3 = 0;
                                if (Objects.equals(q, "Yes")) {
                                    System.out.println("Enter the number of food packs : ");
                                    int r = getInput.nextInt();
                                    TP3 = r;
                                    float Cost5 = r * details[k].foodCost;
                                    NTotalCost.add(Cost5);
                                }
                                System.out.println("Insurance (Yes/No) : ");
                                String u = Input.readLine();
                                int IP3 = 0;
                                if (Objects.equals(u, "Yes")) {
                                    System.out.println("Enter the number of passengers : ");
                                    int e = getInput.nextInt();
                                    IP3 = e;
                                    if (w >= e) {
                                        float Cost6 = e * details[k].insurance;
                                        NTotalCost.add(Cost6);
                                    } else {
                                        System.out.println("Maximum Passengers Reached !\n");
                                    }
                                }
                                float TotalCost3 = 0;
                                for (int c = 0; c < NTotalCost.size(); c++) {
                                    TotalCost3 += NTotalCost.get(c);
                                }
                                System.out.println("\nName : " + name);
                                System.out.println("Train Details : " + b + " " + details[k].TrainName + " " + details[k].fro + " " + details[k].to);
                                System.out.println("Coach : " + Coach);
                                System.out.println("Total Tickets : " + w);
                                if (q.equals("Yes")) {
                                    System.out.println("Food : " + q + " (" + TP3 + ")");
                                } else if (q.equals("No")) {
                                    System.out.println("Food : " + q);
                                } else {
                                    System.out.println("Food : " + "-");
                                }
                                if (u.equals("Yes")) {
                                    System.out.println("Insurance : " + u + " (" + IP3 + ")");
                                } else if (u.equals("No")) {
                                    System.out.println("Insurance : " + u);
                                } else {
                                    System.out.println("Insurance : " + "-");
                                }
                                System.out.println("Total Cost : " + TotalCost3 + "\n");
                            } else {
                                System.out.println("Maximum Seats Reached !\n");
                            }
                        }

                        default -> {
                            System.out.println("Coach doesn't exist !\n");
                        }
                    }
                }
            }
            if(b>details.length){
                System.out.println("Wrong Train Number !\n");
            }
        }
    }
}