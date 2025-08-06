package oopClass.sec01;

public class Car {
    private String plateNo; // 차량 번호
    private String modelName; // 차량 모델명
    private String manufacturer; // 제조사
    private int modelYear; // 모델 연도(연식)
    private int displacement; // 배기량

    public Car() {
    }

    public void setCarInfo(String plateNo, String modelName, String manufacturer, int modelYear, int displacement) {
        this.plateNo = plateNo;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.modelYear = modelYear;
        this.displacement = displacement;
    }

    public void printCarInfo() {
        System.out.printf("차량번호\t:\t%s\n모델명\t:\t%s\n제조사\t:\t%s\n모델연도\t:\t%d\n배기량\t:\t%dcc\n",
                plateNo, modelName, manufacturer, modelYear, displacement);
    }
}
