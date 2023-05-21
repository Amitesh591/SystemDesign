public interface ChristmasTree{
    String decorate();
}
public class ChristmasTreeImpl implements ChristmasTree{
    @Override
    public String decorate(){
        return "Christmas tree";
    }
}
//Abstract TreeDecorator class will implement ChristmasTree interface
//as well as hold the same object
public abstract class TreeDecorator implements ChristmasTree{
    private ChristmasTree tree;
    @Override
    public String decorate(){
        return tree.decorate();
    }
}

//Decorating elements will extend abstract TreeDecorator class and modify its method
public class BubbleLights extends TreeDecorator{
    public BubbleLights(ChristmasTree tree){
        super(tree);
    }

    @java.lang.Override
    public String decorate() {
        return super.decorate()+decorateWithBubbleLights();
    }
    private String decorateWithBubbleLights(){
        return "With Bubble Lighs";
    }
}

class decoratorPattern {
    public static void main(String[] args) {

        System.out.println("Hello, World!");

        @Test
        public void whenDecoratorsInjectedAtRuntime_thenConfigSuccess() {
            ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
            assertEquals(tree1.decorate(),
                    "Christmas tree with Garland");

            ChristmasTree tree2 = new BubbleLights(
                    new Garland(new Garland(new ChristmasTreeImpl())));
            assertEquals(tree2.decorate(),
                    "Christmas tree with Garland with Garland with Bubble Lights");
        }
    }
}