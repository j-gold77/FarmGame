package executor.animal;

import executor.Location;

public class Pig extends Animal {

    public Pig() {
        super();
    }

    public Pig(Location location, int hungry, boolean sick, boolean clean) {
        super(location, hungry, sick, clean);
    }

    @Override
    public String speak() {
        return "The pig oinks!";
    }

    @Override
    public String returnStatus() {
        return "The pig is at the " + getLocation().getName() + ". It is "
                + ((isHungry()) ? "hungry, " : "full, ")
                + ((isSick()) ? "sick, " : "healthy, ")
                + ((isClean()) ? "and clean." : "and filthy.");
    }

    public String picture(){
        return " &_--~- ,_" +
                "\n {        \"," +
                "\n (  )_ ,{ ,_@" +
                "\n |/  {|\\{" +
                "\n \"\"   \" \"";
    }

      /*
    &_--~- ,_
    {        ",
    (  )_ ,{ ,_@
    |/  {|\{
    ""   " "
     */

}