package io.naivekyo.structural.Composite;

import io.naivekyo.structural.Composite.component.Academy;
import io.naivekyo.structural.Composite.component.College;
import io.naivekyo.structural.Composite.component.Introduce;
import io.naivekyo.structural.Composite.component.Major;

public class CompositeTestClient {
    public static void main(String[] args) {
        // tree: root
        Introduce college = new College("xxx大学");
        
        // tree: depth 1
        Introduce academy1 = new Academy("学院1");
        Introduce academy2 = new Academy("学院2");
        Introduce academy3 = new Academy("学院3");
        
        // tree: leaf
        Introduce major11 = new Major(100, "专业11");
        Introduce major12 = new Major(200, "专业12");
        Introduce major13 = new Major(300, "专业13");

        Introduce major21 = new Major(110, "专业21");
        Introduce major22 = new Major(210, "专业22");
        Introduce major23 = new Major(310, "专业23");

        Introduce major31 = new Major(120, "专业31");
        Introduce major32 = new Major(220, "专业32");
        Introduce major33 = new Major(320, "专业33");
        
        // 组装树模型
        college.add(academy1); college.add(academy2); college.add(academy3);
        academy1.add(major11); academy1.add(major12); academy1.add(major13);
        academy2.add(major21); academy2.add(major22); academy2.add(major23);
        academy3.add(major31); academy3.add(major32); academy3.add(major33);
        
        // 测试
        college.intro();
        System.out.println();
        academy1.intro();
        academy2.intro();
        academy3.intro();
        System.out.println();
        major11.intro();
        major22.intro();
        major33.intro();
    }
}
