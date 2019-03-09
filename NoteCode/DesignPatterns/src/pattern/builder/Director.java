package pattern.builder;

import java.util.ArrayList;

public class Director {
    private ArrayList<String> sequence = new ArrayList<String>();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();
    public BenzCar getABenzCar(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzCar)this.benzBuilder.getCar();
    }
        public BenzCar getBBenzCar(){
        this.sequence.clear();
        this.sequence.add("engineBoom");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(sequence);
        return (BenzCar)this.benzBuilder.getCar();
    }
        public BMWCar getCBMWCar(){
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(sequence);
        return (BMWCar)this.bmwBuilder.getCar();
    }
        public BMWCar getDBMWCar(){
        this.sequence.clear();
        this.sequence.add("start");
        this.bmwBuilder.setSequence(sequence);
        return (BMWCar)this.bmwBuilder.getCar();
    }

}
