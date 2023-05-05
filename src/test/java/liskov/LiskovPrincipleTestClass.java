package liskov;

import org.junit.jupiter.api.Test;

public class LiskovPrincipleTestClass {
    
    static class Base {
        public void say(BaseBehavior behavior) {
            System.out.println("this is base.");
            behavior.run();
        }
        
        public BaseBehavior behavior() {
            return new BaseBehavior();
        }
    }
    
    static class Sub extends Base {
        public void say(SubBehavior behavior) {
            System.out.println("this is sub");
            behavior.run();
        }

        @Override
        public SubBehavior behavior() {
            return new SubBehavior();
        }
    }
    
    static class BaseBehavior {
        public void run() {
            System.out.println("base behavior: run");
        }
    }
    
    static class SubBehavior extends BaseBehavior {
        @Override
        public void run() {
            System.out.println("sub behavior: run");
        }
    }
    
    @Test
    public void test() {
        Base base = new Sub();
        base.say(new BaseBehavior());

        Sub sub = (Sub) base;
        sub.say(new BaseBehavior());
        sub.say(new SubBehavior());
    }
}
