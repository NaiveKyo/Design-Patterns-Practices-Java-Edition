# Structural Patterns

结构型设计模式将对象和类组装成更大的结构，同时保证结构的灵活和高效。

## Adapter

### Intent

- 将某个类提供的接口转换为其他客户端接口所期望的接口；适配器就是为了让两个不兼容的接口能够在一起工作而提出的设计模式；
- 将一个已经存在的 class 包装为一个新的接口；
- 将一个旧的 component 接入到新的系统中；

### Problem

一个 "off the shelf"（现成的）组件提供的接口需要重复使用，但是它和正在开发的新系统的某些设计理念或者架构不兼容。

### Discussion

Reuse 一直是一个痛苦的、不容易理解的，其中一个原因是设计新东西的同时又要重复使用旧的东西。新旧事物之间总有些不太对劲的地方。

这就像把一个新的三脚插头插入一个旧的两脚墙壁插座的问题——某种适配器或中介是必要的。

Adapter 设计模式通过提供一个中间层抽象，比如 translates or maps 从而将旧的组件接入新的系统中。Clients 调用 Adapter object 的方法时，内部会将请求重定向到旧的组件中。此策略既可以通过继承（inheritance）实现，也可以通过聚合（aggregation）实现。

Adapter 为一个已经存在的 class 提供 wrapper 或者 modifier，也就是这个 class 的 different 或者 translate view；

### Structure

考虑这样的场景，一个旧的 Rectangle component 的 display 方法接受参数为 `x, y, w, h` 即左上角坐标和宽高，但是现在 client 期望传入左上角坐标和右下角坐标，此时可以通过为旧的 Rectangle 组件添加一个 Adapter Object 来解决不协调问题。

### Example

以 Structure 中例子，假设我们现在要构造一套新的 Shape#dispaly API，可以这样：

Shape 接口：

```java
public interface Shape {
    void display(int x1, int y1, int x2, int y2);
}
```

旧的 Retangle 类：

```java
public class LegacyRectangle {
    
    public void display(int x, int y, int w, int h) {
        System.out.printf("this is legacy rectangle: (x, y, w, h) -> (%d, %d, %d, %d)%n", x, y, w, h);
    }
}
```

新的 Retangle 类：

```java
/**
 * 新的 Rectangle class
 */
public class Rectangle implements Shape {
    
    private LegacyRectangle adaptee;

    public Rectangle(LegacyRectangle adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void display(int x1, int y1, int x2, int y2) {
        // call adaptee's legacy method
        System.out.println("call adapter' display method.");
        this.adaptee.display(x1, y1, (x2 - x1), (y2 - y1));
    }
}
```

测试 client：

```java
public class AdapterTestClient {
    public static void main(String[] args) {
        Shape shape = new Rectangle(new LegacyRectangle());
        shape.display(1, 2, 3, 4);
    }
}
```

期望输出：

```
call adapter' display method.
this is legacy rectangle: (x, y, w, h) -> (1, 2, 2, 2)
```

### Rules of thumb

Adapter 让某些事物在它们被设计完成之后进行工作，而 Bridge 则让它们提前工作；

（Adapter makes things work after they're designed; Bridge makes them work before they are. ）

Bridge 是预先设计好以便让 abstraction 和 implementation 分离。而 Adapter 则将两个类进行改造以便让它们能在一起工作。

- Adapter 为其 subject 提供一个不同的 interface；

- Proxy 提供的则是相同的 interface；
- Decorator 提供的是增强的 interface；

Adapter 用于更改一个已存在的对象的接口。Decorator 在不改变其接口的情况下增强对象的功能。因此，对于应用程序来说，Decorator 比 Adapter 更透明。同时，Decorator 支持递归组合（recursive composition），这是纯粹的 Adapter 所不能做到的。

Facade 定义了一个新的接口，而 Adapter 则复用一个旧的接口。请记住，Adapter 使两个现有接口一起工作，而不是定义一个全新的接口。

## Bridge

### Intent

- 将 abstraction 和该抽象的 implementation 解耦，这样它们就可以分离了；
- 用继承体系来扩展新的接口，同时隐藏每个接口具体的层次实现；
- 要比 encapsulation 更进一步，达到 insulation（绝缘）；

### Problem

"Hardening of the software arteries" 通过使用抽象基类的子类来提供可选的实现，这样在 compile-time 就将 interface 和其 implementation 进行绑定。抽象和实现不能独立地扩展或组合。

### Motivation

参考这样一种场景："thread scheduling"

有这样的继承体系：

```
- ThreadScheduler
-- PreemptiveThreadScheduler
---- UnixPTS
---- WindowsPTS
-- TimeSlicedThreadScheduler
---- UnixTSTS
---- WindowsTSTS
```

这里有两种类型的 thread scheduler，以及两种操作系统或者叫 "platforms"。出于专业化的考虑，我们必须为这两个维度体系提供不同的类。同时，假如我们新定义了一个平台，比如 "Java's Vitrual Machine"，那么新的继承体系又是什么样的呢？

会变成这样：

```
- ThreadScheduler
-- PreemptiveThreadScheduler
---- UnixPTS
---- WindowsPTS
---- JVM_PTS
-- TimeSlicedThreadScheduler
---- UnixTSTS
---- WindowsTSTS
---- JVM_PTS
```

添加两个实现类即可解决问题，那么在进一步考虑，如果定义了三中 thread scheduler、四种 platform？以此类推，我们会发现定义的类和接口越来越多，甚至呈指数级增长。

Bridge 设计模式建议将这种呈指数级爆炸的继承层次结构重构为两个正交的层次结构：

- platform-independent abstractions
- platform-dependent implementations

现在的继承体系是这样的：

```
- ThreadScheduler —> ThreadScheduler_Implementation
-- PreemptiveThreadScheduler
-- TimeSlicedThreadScheduler

- ThreadScheduler_Implementation
-- UnixPTS
-- WindowsPTS
-- JVM_PTS
```

### Discussion

将某个组件的 interface 和 implementation 分离成类似正交的层级结构。在 interface 中关联一个 abstract implementation class。（上面结构中的 -> 实线箭头表示 URL 中的关联关系）

这种关联关系是通过一个实例属性引用来实现的，该引用伴随这接口具体实现类的实例化而实例化，但是所有从 interface class 到 implementation 中的后续交互都仅限于在实现基类中维护的抽象实现引用。

Client 同 interface class 交互，其内部将请求 "delegate" 给具体的 implementation class。

接口对象是客户端已知并使用的 "handle"；而实现对象或 "body" 则被安全封装，以确保它可以继续发展，或在运行时被完全替换 (或共享)。

在以下场景中使用 Bridge 模式：

- 需要在运行时绑定具体的实现；
- 耦合接口和众多实现导致了类的激增；
- 想要在多个对象之间共享某个具体的实现；
- 需要映射正交的类层次结构；

使用 Bridge 模式的效果：

- 将对象的 interface 进行解耦；
- 增强可扩展性（可以分别独立的扩展 abstraction 和 implementation）；
- 对 client 隐藏具体的细节；

Bridge 是 "handle/body" 的同义词。它是这样的一种措施：将实现类封装在接口类中（encapsulates an implementation class inside of an interface class），前者就是 body，后者是 handle。

handle 在用户眼中就是真实的 class，但是具体的工作却是在 body 中完成的。

"The handle/body class idiom may be used to decompose a complex abstraction into smaller, more manageable classes. The idiom may reflect the sharing of a single resource by multiple classes that control access to it (e.g. reference counting)."

### Structure

Client 并不想去处理和 platform-dependent 相关的细节，使用 Bridge 模式可以将其中的复杂操作封装在一个 abstraction "wrapper" 下面；

Bridge 强调从 "implementation" abstraction 中识别和解耦 "interface" abstraction。

### Example

Bridge 将 abstraction 从它的具体 implementations 中解耦，这样抽象和实现就可以独立开来。

控制电灯、吊扇等的家用开关就是桥接模式的一个例子。开关的作用是打开或关闭设备，实际的开关可以实现为一个 pull chain，简单的两个位置开关，或各种调光开关。

具体细节：

- 开关有不同的类型，比如简单的开关（如电视的那种开关，只负责打开和关闭），有如可调节亮度的开关（有些灯可以调节亮度）；
- 将开关同具体的事物结合，又分为电视开关、灯开关；

这样我们就将开关按照控制方式和类型划分为更小粒度的抽象类/接口（这两个维度构成正交关系）；

先看抽象部分（body）：

开关：

```java
/**
 * 开关的抽象非常简单, 只有两个功能: 开/关
 * 此类代表: body
 */
public abstract class Switch {
    
    protected SwitchImplementation implementation;

    public Switch(SwitchImplementation implementation) {
        this.implementation = implementation;
    }

    public abstract void on();
    
    public abstract void off();
    
    public void setImplementation(SwitchImplementation implementation) {
        this.implementation = implementation;
    }
    
}
```

简单的开关：

```java
public class SimpleSwitch extends Switch {

    public SimpleSwitch(SwitchImplementation implementation) {
        super(implementation);
    }

    @Override
    public void on() {
        this.implementation.on();
    }

    @Override
    public void off() {
        this.implementation.off();
    }
}
```

可调节的开关：

```java
public class DimmerSwitch extends Switch {

    public DimmerSwitch(SwitchImplementation implementation) {
        super(implementation);
    }

    @Override
    public void on() {
        this.implementation.on();
    }

    @Override
    public void off() {
        this.implementation.off();
    }
    
}
```

再看实现部分（handle）：

实现的抽象接口：

```java
/**
 * 开关实现的抽象
 * 此接口代表: handle
 */
public interface SwitchImplementation {
    
    void on();
    
    void off();
    
}
```

电视开关：

```java
/**
 * 电视开关只有两种状态: 打开或者关闭
 */
public class TVSwitch implements SwitchImplementation {
    
    @Override
    public void on() {
        System.out.println("Turn on the TV.");
    }

    @Override
    public void off() {
        System.out.println("Turn off the TV.");
    }
    
}
```

可调节的灯的开关：

```java
public class ElectricLampSwitch implements SwitchImplementation {

    /**
     * 灯可以调亮或调暗, 这个字段表示灯光的亮度
     * 0 表示熄灭
     */
    private int level = 0;
    
    @Override
    public void on() {
        if (this.level == 0) {
            this.level++;
            System.out.printf("Turn on the light. [level: %d]%n", this.level);
        } else if (this.level == 1) {
            this.level++;
            System.out.printf("Up the light level. [level: %d]%n", this.level);
        } else if (this.level == 2) {
            System.out.println("Can't up light level, it's already maximum.");
        }
    }

    @Override
    public void off() {
        if (this.level == 2) {
            this.level--;
            System.out.printf("Down the light level. [level: %d]%n", this.level);
        } else if (this.level == 1) {
            this.level--;
            System.out.printf("Turn off the light. [level: %d]%n", this.level);
        } else if (this.level == 0) {
            System.out.println("Can't down light level, it's already minimum.");
        }
    }
}
```

测试类：

简单分析：Client 同 abstraction/body 交互，具体的实现细节则油 implementation/handle 完成，且该细节对 Client 是不可见的。可以在运行时根据需要绑定对应的 implementation。

```java
public class BridgeTestClient {
    public static void main(String[] args) {
        Switch simple = new SimpleSwitch(new TVSwitch());
        simple.on();
        simple.off();

        System.out.println("============================================");
        
        Switch dimmer = new DimmerSwitch(new ElectricLampSwitch());
        dimmer.on();
        dimmer.on();
        dimmer.on();
        dimmer.off();
        dimmer.off();
        dimmer.off();
    }
}
```

期望输出：

```
Turn on the TV.
Turn off the TV.
============================================
Turn on the light. [level: 1]
Up the light level. [level: 2]
Can't up light level, it's already maximum.
Down the light level. [level: 1]
Turn off the light. [level: 0]
Can't down light level, it's already minimum.
```

### Check List

（1）需要判断当前 domain 中存在哪两个维度可以构成正交关系（在上面的例子中开关的种类和具体事物的开关构成一个正交关系），这两个独立的概念类似于：abstraction/platform、or domain/infrastructure，or front-end/back-end，or interface/implementation；

（2）关注点分离设计： what does the client want, and what do the platforms provide. 

（3）Design a platform-oriented interface that is minimal, necessary, and sufficient. Its goal is to decouple the abstraction from the platform.

（4）Define a derived class of that interface for each platform. 

（5）Create the abstraction base class that "has a" platform object and delegates the platform-oriented functionality to it. 

（6）Define specializations of the abstraction class if desired. 

### Rules of thumb

Adapter makes things work after they're designed; Bridge makes them work before they are. 

Adapter 模式可以让一个已经设计好的事物接入新的系统并顺利工作，而 Bridge 模式在设计之初就想好了后面它们该如何工作；

（简而言之，适配器模式对接的是一个过去设计的可能有点问题的组件，而桥接者模式的目的是为了设计一个灵活度高、扩展性好的组件）

Bridge 在设计时将抽象和实现分离，各自可以独立扩展。Adapter 则是让两个不相关的接口可以一起工作。

State、Strategy、Bridge（某种程度上也包括 Adapter）具有相似的解决方案结构。它们都是基于 "handle/body" idiom 的。但是它们的意图不同，因为这些设计模式是为了解决不同的问题而提出的。

从结构上看 State 和 Bridge 是一样的（唯一的区别就在于 Bridge 中存在层级结构，而 State 中只有一层）。这两个模式使用了相同的结构去处理不同的问题：

- 相同的结构是指：State 中对象的 behavior 和 state，Bridge 中的 implementation 和 abstraction；

- State 允许对象的 behavior 随着其 state 的改变而改变，而 Bridge 则是从其 implementation 中将 abstraction 中解耦出去，这样抽象和实现就可以彼此分离。

If interface classes delegate the creation of their implementation classes (instead of creating/coupling themselves directly), then the design usually uses the Abstract Factory pattern to create the implementation objects.



## Composite

组合模式可将对象组合成树状结构，并且能够像使用独立对象一样使用它们。

### Intent

如果应用的核心模型可以使用树状结构表示，在应用中使用组合模式才会有价值。

比如这样的场景：假如存在两类对象：产品 和 盒子，一个盒子中可以包含多个产品或者几个盒子，也可以同时包含盒子和产品，这些小盒子中一样可以包含一些产品和盒子，以此类推。

假如根据这种情况开发一个订购系统，根据不同的情况计算所需要的总价格，此时可以通过组合模式实现；

该方式的最大优点在于你无需了解构成树状结构的对象的具体类。你也无需了解对象是简单的产品还是复杂的盒子。你只需调用通用接口以相同的方式对其进行处理即可。当你调用该方法后，对象会将请求沿着树结构传递下去。

### Structure

在组合模式中通常存在以下角色：

- 组件（Component）：接口定义了树种简单项目和复杂项目所共有的操作；
- 叶节点（Leaf）：树的基本结构，不包含子项目；
  - 一般情况下，Leaf 最终会完成大部分的实际工作，因为它们无法将工作指派给其他部分；
- 容器（Container）又名组合（Composite）：包含 Leaf 或者其他 Container 子项目的单位。容器不知道其拥有的子项目的具体类，它只通过通用的 Component 接口与其子项目交互；
  - 容器接收到请求后会将工作分配给自己的子项目，处理中间结果，然后将最终结果返回给客户端；
- 客户端（Client）：通过组件接口与所有项目交互。因此，客户端能以相同方式与树状结构中的简单或复杂的项目进行交互；



### Example

这里选择一个简单的例子，比如一所大学的结构，从上到下依次是：学校 -> 学院 -> 专业，每个专业有具体的人数，下面开发这样的程序：要打印一所大学的层次结构及其所有人数：

参考前面定义的组合模式中的角色：

组件 Component 接口：

```java
/**
 * 定义所有组件的通用行为
 */
public interface Introduce {

    /**
     * 获得总数量
     * @return
     */
    int total();

    /**
     * 打印相关信息
     * @return
     */
    void intro();
    
    void add(Introduce component);
    
    boolean remove(Introduce component);
    
}
```

容器 Container：

```java
/**
 * 学校是一个 Composite, 包含多个 Leaf 或其他 Composite
 */
public class College implements Introduce {
    
    private String name;
    
    private List<Introduce> academies;

    public College(String name) {
        this.name = name;
        this.academies = new ArrayList<>();
    }

    public College(String name, List<Introduce> academies) {
        this.name = name;
        this.academies = academies;
    }
    
    @Override
    public void add(Introduce component) {
        this.academies.add(component);
    }

    @Override
    public boolean remove(Introduce component) {
        return this.academies.remove(component);
    }

    @Override
    public int total() {
        return this.academies.stream().mapToInt(Introduce::total).sum();
    }

    @Override
    public void intro() {
        System.out.printf("====================== %s 总人数: %d =====================%n", this.name, this.total());
        this.academies.forEach(Introduce::intro);
    }
    
}
```

```java
/**
 * 学院属于 Composite, 可以拥有多个 Leaf 或其他 Composite
 */
public class Academy implements Introduce {
    
    private String name;
    
    private List<Introduce> majors;

    public Academy(String name) {
        this.name = name;
        this.majors = new ArrayList<>();
    }

    public Academy(String name, List<Introduce> majors) {
        this.name = name;
        this.majors = majors;
    }

    @Override
    public void add(Introduce component) {
        this.majors.add(component);
    }
    
    @Override
    public boolean remove(Introduce component) {
        return this.majors.remove(component);
    }

    @Override
    public int total() {
        return this.majors.stream().mapToInt(Introduce::total).sum();
    }

    @Override
    public void intro() {
        System.out.printf("******** %s 总人数: %d *********%n", this.name, this.total());
        this.majors.forEach(Introduce::intro);
    }
    
}
```

子节点 Leaf：

```java
/**
 * 专业属于 Leaf, 是树状结构的最底层, 是工作的实际执行者
 */
public class Major implements Introduce {
    
    private int studentNumber;
    
    private String name;

    public Major(int studentNumber, String name) {
        this.studentNumber = studentNumber;
        this.name = name;
    }

    @Override
    public int total() {
        return this.studentNumber;
    }

    @Override
    public void intro() {
        System.out.println(this.name + " 总人数: " + this.total());
    }

    @Override
    public void add(Introduce component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Introduce component) {
        throw new UnsupportedOperationException();
    }

}
```

测试客户端 Client：

```java
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
```

预期输出：

```
====================== xxx大学 总人数: 1890 =====================
******** 学院1 总人数: 600 *********
专业11 总人数: 100
专业12 总人数: 200
专业13 总人数: 300
******** 学院2 总人数: 630 *********
专业21 总人数: 110
专业22 总人数: 210
专业23 总人数: 310
******** 学院3 总人数: 660 *********
专业31 总人数: 120
专业32 总人数: 220
专业33 总人数: 320

******** 学院1 总人数: 600 *********
专业11 总人数: 100
专业12 总人数: 200
专业13 总人数: 300
******** 学院2 总人数: 630 *********
专业21 总人数: 110
专业22 总人数: 210
专业23 总人数: 310
******** 学院3 总人数: 660 *********
专业31 总人数: 120
专业32 总人数: 220
专业33 总人数: 320

专业11 总人数: 100
专业22 总人数: 210
专业33 总人数: 320
```

### Check List

1、确保应用的核心模式可以使用树状结构表示。尝试将其分解为简单元素和容器。容器必须能够同时包含简单元素和其他容器；

2、声明组件接口及其一系列方法，这些方法对简单元素和复杂元素都有意义；

3、创建一个叶子节点表示简单元素，程序中可以有多个不同的简单元素类；

4、创建一个容器类表示复杂元素。在该类中创建一个数组成员变量来存储对其子元素的引用。数组成员类型需要声明为组件接口类型；

容器实现组件中的方法时，注意需要把实际的工作指派给子元素；

5、最后，在容器中定义添加和删除子元素的方法。

注意：类似添加和删除的操作也可以在组件接口中声明（类似前面 Example 模块中相关代码示例），但是这会违背 `接口隔离原则`，因为叶子节点是不支持这些方法的。这样做的好处就和前面 Example 中 Client 示例代码一样，可以让客户端无差别地访问所有子元素，即使是组成树状结构的元素。



### Advantage/Disadvantage

优点：

- 可以利用多态和递归机制更方便的使用复杂的树状结构；
- 模式遵循 `开闭原则`，无需更改现有代码就可以通过继承机制添加新的元素，使其成为对象树的一部分；

缺点：

- 对于功能差异较大的类，提供公共接口或许有一定的难度；某些情况下如果一定要抽出接口，可能会让该接口变得难以理解；

### Rules of thumb

- 桥接、状态和策略（包括某些适配器）模式的接口非常相似，都采用了和组合模式相同的思想 —— 将工作委派给其他对象，但是各自又解决了不同的问题；
- 可以在创建复杂的组合树时使用 Builder；
- Responsibility Chain 通常和 Composite 模式一起使用。此时，叶子组件收到请求后，可以将请求沿着包含所有父组件的链一直传递到对象树的底部；
- 可以使用迭代器来遍历组合树；
- 可以使用访问者对整个组合树执行操作；
- 可以使用享元实现组合树中共享叶子节点来节省内存占用；
- 组合和装饰的结构很相似，因为两者都依赖递归组合来组织大量的对象；

Decorator 类似于 Composite，但其只有一个子组件。此外还有一个明显不同：Decorator 为被封装的对象添加了额外的职责，Composite 仅对其子节点的结果进行了汇总 "求和"。

当然，模式也可以相互合作，可以使用装饰器来扩展组合树中特定对象的行为；

- 大量使用组合和装饰的设计通常可以从对原型的使用中获益，可以通过该模式复制对象，而无需从零开始构建；



## Decorator

装饰器模式又称：封装器、Wrapper、Decorator

将原对象放入包含特殊行为的封装对象中，从而为原对象绑定新的行为；

### Problem

考虑这样的场景：假设正在开发一款用于发送通知消息的程序，默认使用短信通知的方式，程序很简单，提供一个发送消息的接口，和其短信实现类即可，但是如果后续增加了 QQ、微信通知，此时也可以通过添加对应的实现类来实现该功能，但是每一次程序在启动的时候只会选择其中一种方式。且如果用户想要同时实现任意两种或多种通知的组合，则需要添加更多的实现类。

### Discussion

通常当我们需要改变一个对象的行为时，首先想到的是扩展它所属的类，但是继承有一些缺点：

- 继承是静态的：无法在运行时改变已有对象的行为，只能由不同子类创建的对象来替代当前整个对象；
- 子类只有一个父类：大部分编程语言不允许多继承；

除了继承外，另外一种方法是通过聚合或组合。继承和聚合/组合的工作方式几乎一模一样：

- 聚合/组合：一个对象拥有对另一个对象的引用，将部分工作委派给引用对象；
- 继承中的对象则是继承了父类的行为，它们自己就可以完成这部分工作；

如果我们用聚合/组合来替代继承机制，就可以在运行时切换不同的引用对象来动态改变对象的行为，可以将各种不同的工作委派给不同的对象处理；

<font style='color:green'>聚合/组合是许多设计模式背后的关键原则之一。</font>

封装器是装饰器模式的别名，这个名称明确的阐释了该模式的主要思想："封装器" 是一个能与其他 "目标" 对象连接的对象。封装器中包含与目标对象相同的一系列方法，它将收到的请求委派给目标对象。但是封装器可以在将请求委派给目标前后做一些处理，所以可能会改变最终的结果。

### Structure

在包装器模式中存在以下角色：

- 部件（Component）：声明封装器和被封装对象的公用接口；
- 具体部件（Concrete Component）：该类是被封装对象所属的类，它定义了基础行为，但装饰器可以改变这些行为；
- 基础装饰（Base Decorator）：该类拥有一个指向被封装对象的引用成员变量。该变量的类型应当声明为通用部件接口，这样它就可以引用具体的部件和装饰。装饰基类会将所有操作委派给被封装的对象；
- 具体装饰类（Concrete Decorator）：定义了可动态添加到部件的额外行为。具体装饰类会重写装饰基类的方法，并在调用父类方法之前或之后进行额外的处理；
- 客户端（Client）：可以使用多层装饰来封装部件，最后通过通用接口与其进行交互；



### Example

下面是前面通知问题的相关 Java 代码实现：

通用接口：

```java
public interface Notifier {
    
    void send(String message);
    
}
```

通用接口的具体实现：

```java
public class SMSNotifier implements Notifier {
 
    @Override
    public void send(String message) {
        this.sendSMS(message);
    }
    
    protected void sendSMS(String message) {
        System.out.println("Notification facility: SMS :: msg :: " + message);
    }
    
}
```

装饰器基类：

```java
public class NotifierDecorator implements Notifier {
    
    protected Notifier wrapper;

    public NotifierDecorator(Notifier wrapper) {
        this.wrapper = wrapper;
    }

    // 基类装饰器会将具体工作委派给被封装的组件
    @Override
    public void send(String message) {
        this.wrapper.send(message);
    }
    
}
```

具体装饰：

```java
public class QQNotifierDecorator extends NotifierDecorator {

    public QQNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    // 具体装饰器子类可以在调用被封装对象之前或之后做一些操作
    @Override
    public void send(String message) { 
        super.send(message);
        this.sendQQ(message);
    }
    
    protected void sendQQ(String message) { 
        System.out.println("Notification facility: QQ :: msg :: " + message);
    }
}
```

```java
public class WeChatNotifierDecorator extends NotifierDecorator {

    public WeChatNotifierDecorator(Notifier wrapper) {
        super(wrapper);
    }

    // 具体装饰器子类可以在调用被封装对象之前或之后做一些操作
    @Override
    public void send(String message) {
        super.send(message);
        this.sendWeChat(message);
    }
    
    protected void sendWeChat(String message) {
        System.out.println("Notification facility: WeChat :: msg :: " + message);
    }
}
```

客户端 Client：

```java
public class DecoratorTestClient {
    public static void main(String[] args) {
        boolean qqNotificationEnable = true;
        boolean weChatNotificationEnable = true;
        
        Notifier notifier = new SMSNotifier();
        
        // 这里模拟程序在运行时根据不同的配置启用不同的装饰
        if (qqNotificationEnable)
            notifier = new QQNotifierDecorator(notifier);
        if (weChatNotificationEnable)
            notifier = new WeChatNotifierDecorator(notifier);

        notifier.send("test msg");
    }
}
```

预期输出：

```
Notification facility: SMS :: msg :: test msg
Notification facility: QQ :: msg :: test msg
Notification facility: WeChat :: msg :: test msg
```

### Scenario

适用场景：

（1）如果希望在无需修改已有代码的前提下即可使用对象，且希望在运行时为对象增加新的行为，即可使用装饰器模式。

Decorator 可以将业务逻辑组织为层状结构，每一层对应一个具体的装饰，在运行时将各种不同逻辑组合对象。由于这些对象都遵循通用接口，客户端代码可以以相同方式访问这些对象。

（2）如果用继承扩展对象行为的方式难以实现或者不可行，此时可以使用装饰器模式。

在某些编程语言中使用 final 修饰类来阻止扩展该类，此时可以使用装饰器模式对其进行封装。

### Check List

1. 确保业务逻辑可以用一个基本组件和多个额外可选层次表示；
2. 找出基本组件和可选层次的通用方法。创建一个组件接口并将这些方法声明在其中；
3. 创建一个具体组件类，并定义其基础行为；
4. 创建装饰基类，使用一个成员变量存储被封装对象的引用。该成员变量必须声明为通用组件接口类型，从而在运行时连接具体组件和装饰。装饰基类必须将具体的工作委派给被封装对象；
5. 确保所有类实现组件接口；
6. 将装饰基类扩展为具体装饰。具体装饰必须在调用父类方法之前或之后执行自身的行为；
7. 客户端代码负责创建装饰并将其组合成客户端所需要的方式；

### Advantage/Disadvantage

优点：

- 无需创建新的子类即可扩展对象的行为；
- 可以在运行时添加或删除对象的功能；
- 可以用将被封装的对象设置为装饰，从而组合几种行为；
- 符合单一职责原则：将实现了很多不同行为的一个大类拆分为多个小类；

缺点：

- 在封装器栈中删除特定的封装器非常困难；
- 实现行为不受装饰栈影响的装饰比较困难；
- 各层的初始化配的代码可能有些差别，导致这部分代码看起来比较糟；

### Rules of thumb

- Adapter 可以对已有对象的接口进行修改，Decorator 则可以在不改变对象接口的前提下强化对象功能。此外，装饰还支持递归组合，适配器则无法实现；
- Adapter 能够为被封装对象提供不同的接口，Proxy 能为对象提供相同的接口，Decorator 则为对象提供增强的接口；
- Responsibility Chain 和 Decorator 的类结构非常类似。两者都依赖递归组合将需要执行的操纵传递给一系列对象。但是两者有几个重要的不同之处：
  - 职责链的管理者可以相互独立的执行一切操作，还可以随时停止传递请求。
  - 各种装饰可以在遵循基础接口的情况下扩展对象的行为，此外，装饰无法中断请求的传递。
- Composite 和 Decorator 的结构图也很类似，两者都依赖递归组合来组织无限数量的对象；
  - 装饰类似于组合，但是装饰只有一个子组件。还有一个明显的不同：装饰为被封装对象添加了额外的职责，组合仅仅对其子节点的结果进行了 "求和"；
  - 但是，模式也可以相互合作，可以使用装饰来扩展组合树中特定对象的行为；
- 大量使用 Composite 和 Decorator 的设计通常可以利用 Prototype 模式来复制复杂的结构，而非从零开始构造；
- Decorator 可以更改对象的外观，Strategy 则可以改变对象的本质；
- Decorator 和 Proxy 有着相似的结构，但是其目的不同。这两个模式的构建都基于组合原则，也就是一个对象应该将部分工作委派给另一个对象。两者的不同之处在于 Proxy 通常自行管理其服务对象的生命周期，而 Decorator 的生成总是由客户端控制。



## Facade

外观模式能为程序库、框架或其他复杂类提供一个简单的接口；

### Problem

假设需要在程序中使用某个复杂的库或框架中的众多对象。正常情况下代码中需要负责所有类的初始化工作、管理其依赖关系并按照正确的顺序执行方法等等。

最终会导致程序中的业务逻辑将会与第三方类的实现细节紧密相关，不利于后续维护。

### Solution

外观类为包含许多组件的子系统提供了一个简单的接口。与直接调用子系统相比，外观提供的功能可能比较有限，但它却包含了客户端真正关心的功能。

如果程序中需要与包含几十种功能的复杂库整合，但是只需要使用其中非常少的功能，那么使用外观模式就会非常方便。

### Structure

外观模式中存在以下集中角色：

（1）外观（Facade）：提供了一种访问特定子系统功能的便捷方式，这些接口知道要处理的请求类型，以及所需的子系统相关组件；

（2）附加外观（Additional Facade）：该类可以避免多种不相关的功能污染单一外观，使其变成又一个复杂结构。客户端和其他外观都可以使用附加外观；

（3）复杂子系统（Complex Subsystem）：由数十个不同的对象构成。如果要用这些对象完成有意义的工作，就必须深入了解子系统的实现细节，比如按照正确顺序初始化对象并为其提供正确格式的数据等等；

子系统类不会意识到外观的存在，它们在系统内运作并且相互之间可以进行直接交互；

（4）客户端（Client）：使用外观类完成业务逻辑，避免对子系统的直接调用。

### Example

考虑这样的场景：想要实现将一种格式的视频转换为另一种格式的视频文件的接口，需要利用多个视频相关的子系统，比如编解码器、视频数据读取/生成组件、音视频混合器等等。

我们可以创建一个外观类封装所需要的功能，并隐藏和子系统交互的代码，这样未来如果更换了相关库或框架，只需要重写外观类即可。

子系统相关类：

```java
public class VideoFile {
    private String fileName;

    public VideoFile(String fileName) {
        this.fileName = fileName;
        // ......
    }
}

public class CodecFactory {
	// ......
}

public class MPEG4CompressionCodec {
	// ......
}

public class OggCompressionCodec {
	// ......
}

public class BitrateReader {
	// ......
}

public class AudioMixer {
	// ......
}
```

外观类：

```java
/**
 * Facade 类: 屏蔽内部利用多个子系统进行复杂的处理, 对外暴露特定的接口; <br/>
 * 这些接口并不会包含子系统所能提供的所有功能, 而是提供用户关心的接口, 后续可以继续添加相关接口, 或者重写外观类;
 */
public class VideoConverter {
    
    public VideoFile converter(String fileName, String format) {
        VideoFile file = new VideoFile(fileName);
        
        // ........
        
        return obj;
    }
}
```

客户端：

```java
public class FacadeTestClient {
    public static void main(String[] args) {
        VideoConverter converter = new VideoConverter();
        // ..........
    }
}
```

### Scenario

- 需要一个指向复杂子系统的简单接口，且该接口功能有效，则可以使用外观模式；

子系统通常会随着时间的推进变得越来越复杂。即便是应用了设计模式，通常你也会创建更多的类。尽管在多种情形中子系统可能是更灵活或易于复用的，但其所需的配置和样板 代码数量将会增长得更快。为了解决这个问题，外观将会提供指向子系统中最常用功能的快捷方式，能够满足客户端的大部分需求。

- 如果需要将子系统组织成多层结构，可以使用外观；

创建外观来定义子系统各层次的入口。也可以要求子系统仅通过外观交互，以减少各层之间的耦合。



### Rules of thumb

- Facade 为现有的对象定义了一个新的接口，Adapter 通常则会试图运用已有的接口。Adapter 中通常只会封装一个对象，Facade 则会作用于整个子系统的对象上；
- 当只需要对客户端代码隐藏子系统创建对象的方式时，可以使用 Abstract Factory 代替 Facade；
- Flyweight 展示了如何生成大量的小型对象，Facade 则展示了如何用一个对象来代表整个子系统；
- Facade 和 Mediator（中介者）的职责类似：它们都尝试组织大量紧密耦合的类完成某些功能；
  - Facade 为子系统中所有对象设计一个简单接口，但是它不会提供任何新的功能。子系统本身不会意识到外观的存在，子系统中所有对象可以直接进行交流；
  - Mediator 将系统中组件的沟通行为中心化。各组件只知道中介者对象，无法直接相互交流；
- Facade 类通常可以转换为 Singleton 类，因为在大部分情况下一个外观对象就足够了；
- Facade 和 Proxy 的相似之处在于它们都缓存了一个复杂实体并负责对其进行初始化。代理与其服务对象遵循同一接口，使得自己和服务对象可以互换，在这一点上它与外观不同；

## Flyweight

享元模式摒弃了在每个对象中保存所有数据的形式，通过共享多个对象所共有的相同状态，从而在有限的内存容量中载入更多的对象；

### Problem

考虑这样的场景：在开发一款射击游戏时，每个子弹具备特定的属性，比如坐标、移动矢量、速度、颜色、精灵图（sprite），当界面中存在大量子弹时，内存的占用量就会迅速升高，因为每个子弹在内存中占据的位置都是不同的。

### Solution

对子弹的内存组成进行分析，可以发现坐标、移动矢量、速度这三个属性都是动态变化的， 而颜色和精灵图只有几种，此时可以考虑使用享元模式来解决内存占用过多的问题；

对象的常量数据通常称为 `内在状态`，这部分数据不能被其他对象修改，只能读取其数值。而对象的其他状态往往能够被其他对象从外部改变，这类属性称为 `外部状态`。

享元模式建议不在对象中存储外部状态，而是将其传递给依赖于它的一个特殊方法。程序只在对象中维持内部状态，以便在不同情况下复用。此时程序中需要的对象数量将会大量减少。

<font style='color:green'>将一个仅存储内部状态的对象称为享元。</font>

### Structure

（1）外部状态存储

内在状态由享元对象存储，而外在状态大部分情况下由容器对象存储，也就是我们在应用享元模式之前的聚合对象（在射击游戏场景中，这个聚合对象就是 Game 这个游戏容器对象，里面含有所有子弹对象）。

一种更好的方式是创建独立的情景类来存储外部状态和对享元对象的引用（本例中就是改造后的子弹对象）；

和没有使用享元模式时相比，情景对象的数量还是会不断增加，但是内在状态对应的享元对象的数量却少了很多。现在一个享元大对象会被上千个情景小对象复用，因此无需重复存储数千个大对象的数据。

（2）享元与不可变性

由于享元对象可在不同的情景中使用，你必须确保其状态不能被修改。享元类的状态只能由构造函数的参数进行一次性初始化，它不能对其他对象公开其设置器或公有成员变量。

（3）享元工厂

为了能更方便地访问各种享元，你可以创建一个工厂方法来管理已有享元对象的缓存池。工厂方法从客户端处接收目标享元对象的内在状态作为参数，如果它能在缓存池中找到所需享元，则将其返回给客户端；如果没有找到，它就会新建一个享元，并将其添加到缓存池中。

你可以选择在程序的不同地方放入该函数。最简单的选择就是将其放置在享元容器中。除此之外，你还可以新建一个工厂类，或者创建一个静态的工厂方法并将其放入实际的享元类中。

享元模式中存在以下角色：

1. 享元模式只是一种优化，在应用该模式之前，要确定程序中存在大量相似对象占用大量内存的问题，并且确保该问题无法使用其他更好的方式解决；
2. 享元（Flyweight）类中包含原始对象中部分能够在多个对象中共享的状态。同一享元对象可以在很多不同的情景中使用。享元中存储的状态被称为 "内部状态"。传递给享元方法的状态被称为 "外部状态"；
3. 情景（Context）类中包含原始对象中各不相同的外在状态。情景与享元对象组合在一起表示原始对象的全部状态；
4. 通常情况下，原始对象的行为会保存在享元类中。因此调用享元方法必须提供部分外在状态作为参数。但是也可以将行为移到情景类中，然后将连入的享元作为单纯的数据对象；
5. 客户端（Client）负责计算和存储享元的外在状态。在客户端看来，享元是一种可在运行时配置的模板对象，具体的配置方式为向其方法中传入一些情景数据参数；
6. 享元工厂（Flyweight Factory）会对已有享元的缓存池进行管理。有了工厂后，客户端就无需直接创建享元，它们只需调用工厂并向其传递目标享元的一些内在状态参数即可。工厂会根据参数在之前已经创建的享元中进行查找，如果找到满足条件的享元就将其返回；否则就根据参数创建新的享元并返回；

### Example

参考下面的例子：在画布上需要渲染上万个树状对象；

利用享元模式从树 Tree 类中抽取内在状态，并将其移动到享元类 TreeType 中，最初程序需要为每个树对象准备一份独有的内存空间，而现在仅需要用几个享元对象保存内部状态，然后在作为情景的树对象中连入享元即可。

客户端代码使用享元工厂创建树对象并封装搜索指定对象的复杂行为，并能在需要时复用对象；

享元对象：

```java
/**
 * 享元对象: 本例中享元中含有树对象的内在状态, 也即每个树唯一的数据
 */
public class TreeType {

    /**
     * 类型
     */
    private String type;

    /**
     * 颜色
     */
    private String color;

    /**
     * 纹理
     */
    private String texture;

    public TreeType(String type, String color, String texture) {
        this.type = type;
        this.color = color;
        this.texture = texture;
    }

    /**
     * 本例子中在享元类中封装原始对象的行为, 将外部状态作为参数传递给此方法 <br/>
     * 在画布的指定坐标 (x, y) 处绘制树图形
     * @param canvas    画布
     * @param x         x-axis
     * @param y         y-axis
     */
    public void draw(Object canvas, int x, int y) {
        // ......
        System.out.printf("type: %s, color: %s, texture: %s, (%d, %d)%n", this.type, this.color, this.texture, x, y);
    }
    
    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getTexture() {
        return texture;
    }
}
```

享元工厂：

```java
/**
 * 享元工厂: 复用或创建一个新的享元
 */
public class TreeFactory {
    
    private static List<TreeType> flyweight = new CopyOnWriteArrayList<>();
    
    public static TreeType getTreeType(String type, String color, String texture) {
        TreeType find = flyweight.stream().filter(tree ->
                // do search ...
                type.equals(tree.getType())
                        && color.equals(tree.getColor())
                        && texture.equals(tree.getTexture())).findFirst().orElse(null);
        
        if (find == null) {
            // concurrency support
            TreeType treeType = new TreeType(type, color, texture);
            flyweight.add(treeType);
            return treeType;
        } else 
            return find;
    }

    /**
     * 获取享元缓存池, 测试使用
     * @return 缓存池
     */
    public static List<TreeType> getFlyweight() {
        return flyweight;
    }
}
```

情景类（包含原始对象持有的内部/外部状态）：

```java
/**
 * 情景类: 包含原始树对象的外在状态以及一个对享元对象的引用 <br/>
 * 程序中可以创建无限量的情景对象, 因为它们占用内存空间很小
 */
public class Tree {

    /**
     * x-axis
     */
    private int x;

    /**
     * y-axis
     */
    private int y;

    /**
     * 包含内部状态的享元对象的引用
     */
    private TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    public void draw(Object canvas) {
        this.treeType.draw(canvas, this.x, this.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public void setTreeType(TreeType treeType) {
        this.treeType = treeType;
    }
}
```

Client 交互客户端：

```java
/**
 * Client: 在本例中 Tree 和 Forest 类都是享元的客户端
 */
public class Forest {
    
    private List<Tree> trees;

    public Forest() {
        this.trees = new ArrayList<>();
    }

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        this.trees.add(tree);
    }
    
    public void draw(Object canvas) {
        this.trees.forEach(t -> t.draw(canvas));
    }
    
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(1, 1, "type1", "red", "aaa");
        forest.plantTree(2, 2, "type2", "yellow", "bbb");
        forest.plantTree(3, 3, "type3", "green", "ccc");

        forest.plantTree(4, 4, "type2", "yellow", "bbb");
        
        forest.draw(new Object());
        
        // insight into flyweight cached pool
        TreeFactory.getFlyweight().forEach(System.out::println);
    }
}
```

预期输出：

```
type: type1, color: red, texture: aaa, (1, 1)
type: type2, color: yellow, texture: bbb, (2, 2)
type: type3, color: green, texture: ccc, (3, 3)
type: type2, color: yellow, texture: bbb, (4, 4)

io.naivekyo.structural.Flyweight.flyweight.TreeType@7291c18f
io.naivekyo.structural.Flyweight.flyweight.TreeType@34a245ab
io.naivekyo.structural.Flyweight.flyweight.TreeType@7cc355be
```



### Scenario

适用场景：

程序必须支持大量对象且没有足够的内存容量时考虑使用享元模式；

应用该模式所获的收益大小取决于使用它的方式和场景。它在以下场景中最有效：

- 程序需要生成数量巨大的相似对象；
- 很快内存将被耗尽；
- 可以从这些对象中抽取能够在多个对象之间共享的重复状态；



### Check List

（1）将需要改写为享元的类的成员变量拆分为两个部分：

- 内在状态：包含不变的、可在许多对象中重复使用的数据对应的成员变量；
- 外在状态：包含每个对象不同的情景数据的成员变量；

（2）保留类中表示内在状态的成员状态，并将其属性设置为不可修改，这些变量尽可通过构造函数进行初始化；

（3）找到所有使用外在状态成员变量的方法，为这些成员变量提供参数；

（4）可以有选择地创建工厂类来管理享元缓存池；如果选用工厂，客户端就只能通过工厂来请求享元，需要将内在状态作为参数传递给工厂方法；

（5）客户端必须存储和计算外在状态对应的数据，利用这些数据调用享元对象的方法。为了方便处理，可以再抽取出一个情景类存储外在状态和一个对享元对象的引用变量。



### Rules of thumb

- 用 Flyweight 实现 Composite 树的共享叶子节点以节省内存；
- Flyweight 展示了如何生成大量的小型对象，Facade 则展示了如何用一个对象来代表整个子系统；
- 如果能够将对象的所有共享状态简化为一个享元对象，那么 Flyweight 就和 Singleton 类似了。但是这两个模式有两个根本性的不同之处：
  - Singleton 只有一个单例实体，Flyweight 可以有多个实体，各个实体的内部状态也可以不同；
  - 单例对象可以是可变的，而享元对象是不可变的；



## Proxy

代理模式能够提供对象的替代品或者占位符。代理控制着对原对象的访问，并在原对象处理请求前后进行一些额外的处理。

### Intent

举个例子，如果有一个消耗大量系统资源的对象，但是使用频率不高，我们希望它能够延迟初始化，在实际需要使用该对象的时候再执行初始化代码；

如果这个类由我们自行提供，则可以通过编写额外的代码来解决这个问题，但是往往这种类由第三方封闭库提供，开发者没法直接修改该类源码；

此时代理模式建议新建一个与原服务对象接口相同的代理类，应用程序只需和该代理类沟通即可，代理类接受到客户端请求后会创建实际的服务对象，并将所有工作委派给它。

这样有什么好处呢？如果需要在类的主要业务逻辑前后执行一些工作，使用代理则无需修改目标类就可以完成这些工作。由于代理实现的接口与原类相同，因此可以将其传递给任何一个使用实际服务对象的客户端。

### Structure



- 服务接口（Service Interface）：声明了服务接口。代理必须遵循该接口才能伪装成服务类；
- 服务（Service）类提供了一些实用的业务逻辑；
- 代理（Proxy）类包含一个指向服务对象的引用成员变量，代理完成其工作（比如延迟初始化、记录日志、访问控制和缓存等等）后会将请求传递给服务对象。同时代理对象对服务对象的整个生命周期进行管理；
- 客户端（Client）通过同一接口与服务或者代理进行交互；



### Scenario

使用代理模式的场景有很多，下面列出常用的一些场景：

- 延迟初始化（虚拟代理）：如果有一个偶尔使用的重量级服务对象，一直保持该对象运行会消耗系统资源时，可以使用代理模式；

无需在程序启动时就创建该对象，可将对象的初始化延迟到真正需要使用的时候；

- 访问控制（保护代理）：如果希望特定客户端使用服务对象，这里的对象可以是操作系统中非常重要的部分，而客户端则是已启动的程序（包括恶意程序），此时可以使用代理模式；

代理将对客户端的凭据进行检验，满足要求才会将请求传递给服务对象；

- 本地执行远程服务（远程代理）：适用于服务对象位于远程服务器上的情形；

此种情况下，代理通过网络传递客户端请求，负责处理所有与网络相关的复杂细节；

- 记录日志请求（日志记录代理）：适用于需要保存对服务对象的请求历史记录时；

代理可以在向服务传递请求前进行记录；

- 缓存请求结果（缓存代理）：适用于需要缓存客户请求结果并对缓存生命周期进行管理时，特别是当返回结果的体积非常大时；

代理可对重复请求所需的相同结果进行缓存，还可以使用请求参数作为索引缓存的键值；

- 智能引用。可以在客户端不在使用某个重量级对象的时候销毁该对象。

代理需要记录所有引用了服务对象及其结果的客户端，时不时进行检查这些客户端是否在运行。如果相应的客户端列表为空，代理就会销毁该服务对象，释放底层资源；

代理还可以记录客户端是否修改了服务对象。其他客户端还可以复用未修改的对象。

### Check List

（1）如果没有现成的服务接口，你就需要创建一个接口来实现代理和服务对象的可交换性。从服务类中抽取接口并非总是可行的，因为你需要对服务的所有客户端进行修改，让它们使用接口。备选计划是将代理作为服务类的子类，这样代理就能继承服务的所有接口了。

（2）创建代理类，其中必须包含一个存储指向服务的引用的成员变量。通常情况下，代理负责创建服务并对其整个生命周期进行管理。在一些特殊情况下，客户端会通过构造函数将服务传递给代理。

（3）根据需求实现代理方法。在大部分情况下，代理在完成一些任务后应将工作委派给服务对象。

（4）可以考虑新建一个构建方法来判断客户端可获取的是代理还是实际服务。 你可以在代理类中创建一个简单的静态方法，也可以创建一个完整的工厂方法。

（5）可以考虑为服务对象实现延迟初始化。

### Example

在 Java 中有两种代理模式：静态代理和动态代理；

静态代理即传统的代理方式，基于相同接口和聚合实现；

动态代理则是结合 Java 语言本身的特性实现的，无需编写类模板，即可在运行时动态生成 JVM 构造的代理类的实例；

下面看一下动态代理实现：

服务接口 Service Interface：

```java
public interface Service {
    void doSomething1();
    void doSomething2();
}
```

服务 Service：

```java
public class ServiceImpl implements Service{
    @Override
    public void doSomething1() {
        System.out.println("agent: do something1.");
    }

    @Override
    public void doSomething2() {
        System.out.println("agent: do something 2.");
    }
}
```

代理类关联的 InvocationHandler（Java 提供）：

```java
public class JDKDynamicProxy implements InvocationHandler {

    /**
     * 被代理的真实对象
     */
    private Object agent;

    private JDKDynamicProxy(Object agent) {
        this.agent = agent;
    }

    /**
     * 获取动态生成的代理类实例
     * @param obj 目标接口的实现类
     * @return proxy instance
     */
    public static Object getObject(Object obj) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return Proxy.newProxyInstance(cl, obj.getClass().getInterfaces(), new JDKDynamicProxy(obj));
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object methodResult = null;
        try {
            System.out.println("proxy: before...");
            methodResult = method.invoke(this.agent, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            System.out.println("proxy: after...");
        }
        return methodResult;
    }
    
}
```

可以看到 InvocationHandler 中聚合了服务对象，这里通过静态方法 `getObject` 内部使用 Proxy 动态构造代理类实例，而实现了 InvocationHandler 接口的 invoke 方法则进行代理的实际工作，这里仅仅在将客户端请求传递给服务对象前后进行日志打印，且对服务对象方法的调用通过反射机制实现。

客户端 Client：

```java
public class DynamicProxyClientTest {
    public static void main(String[] args) {
        Service s = new ServiceImpl();
        Service proxy = (Service) JDKDynamicProxy.getObject(s);
        proxy.doSomething1();
        proxy.doSomething2();
    }
}
```

预期输出：

```
proxy: before...
agent: do something1.
proxy: after...

proxy: before...
agent: do something 2.
proxy: after...
```

注意动态生成的代理类实例继承了 Proxy 同时实现了 Service 接口；

Java 的动态代理机制是基于接口实现的，主要目的是为了代理相关接口中定义的方法，可以同时代理多个接口，但是也有相关限制，具体参加 jdk 官方文档描述；

### Advantage/Disadvantage

优点：

- 代理控制服务对象对客户端是透明的；
- 如果客户端对服务对象的生命周期没有特殊要求，你可以对其生命周期进行管理；
- 即使服务对象还未准备好或不存在，代理也可以正常工作；
- 满足开闭原则，可以在不对服务或客户端修改的前提下创建新的代理；



缺点：

- 需要新建很多类，可能会导致代码变得复杂；
- 服务响应也许会延迟；

### Rules of thumb

- Adapter 能为被封装的对象提供不同的接口，Proxy 能为对象提供相同的接口，Decorator 能为对象提供增强的接口；
- Facade 和 Proxy 的相似之处在于它们都缓存了一个复杂实体并自行对其进行初始化。Proxy 与其服务对象遵循同一接口，可以和服务对象互换，在这一点上它和 Facade 不同；
- Decorator 和 Proxy 具有相似的结构，但是其目的不一样。这两个模式的构建都基于组合原则，也就是一个对象应该将部分工作委派给另一个对象。两者之间的不同之处在于 Proxy 通常自行管理其服务对象的生命周期，而 Decorator 的生成则总是由客户端进行控制；