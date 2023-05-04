# 概览

参考：

- https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm
- https://refactoring.guru/
- https://refactoringguru.cn/

在软件工程中，设计模式是针对软件设计中常见问题的通用解决方案。设计模式不是可以直接转换为代码的成品设计。它是解决某类问题的描述或模板，需要结合项目实际情况来使用它们。

良好的软件设计需要在开发最初就要考虑到后期可能遇到的问题，而利用设计模式可以避免一些细节问题，此类问题一般会在项目后期导致一些不必要的麻烦。同时设计模式也可以提高代码的可读性。

通常，人们只了解如何将特定的软件设计技术应用于特定的问题，但是这些技术很难应用于更广泛的问题。设计模式提供通用的解决方案，并且不与特定的问题细节相关，仅仅作为一份描述或模板。

此外，模式允许开发人员使用众所周知的、易于理解的软件交互名称进行通信。随着时间推移，通用的设计模式会不断改进。



# 分类

主流的设计模式主要分为三类：

## Creational Patterns（创建型模式）

此类模式主要涉及到类的实例化（instantiation）。同时创建型模式又可以继续细分为两类：

- `class-creation patterns`：类创建模式使用 inheritance （继承）来提高实例化的效率；
- `object-creation patterns`：对象创建模式使用 delegation （委托）来高效的完成工作；

创建型模式主要由以下设计模式组成：

- Abstract Factory；
  - Creates an instance of several families of classes 
  - 抽象工厂：创建多种类族的类的实例；
- Builder：
  - Separates object construction from its representation
  - 建造者：将对象的构造和表现分离开；
- Factory Method；
  - Creates an instance of several derived classes 
  - 工厂方法：创建多个派生类的实例；
- Object Pool；
  - Avoid expensive acquisition and release of resources by recycling objects that are no longer in use
  - 对象池模式：通过回收不再使用的对象来避免昂贵的创建和回收资源的操作；
- Prototype；
  - A fully initialized instance to be copied or cloned
  - 原型模式：可以复制或克隆一个完全初始化的实例；
- Singleton；
  - A class of which only a single instance can exist
  - 单例模式：特定的 class 只能存在一个实例；

## Structural Patterns（结构型模式）

此种类型的设计模式主要涉及 Class 和 Object 的不同组合方式，也可以细分为两类：

- `Structural class-creation patterns`：结构化的类创建模式使用 inheritance 来组合不同的 interfaces；
- `Structural object-pattern`：结构化的对象模式提供了某种方法来组合不同的对象，从而提供新的功能；

结构型模式主要由以下设计模式组成：

- Adapter；
  - Match interfaces of different classes 
  - 适配器模式：将不同类的接口进行匹配，这样它们就可以在一起工作；
- Bridge；
  - Separates an object’s interface from its implementation
  - 桥接模式：将对象的接口和实现分离；
- Composite；
  - A tree structure of simple and composite objects 
  - 组合模式：用树状结构表示简单和复合两种不同的对象；
- Decorator；
  - Add responsibilities to objects dynamically 
  - 装饰器模式：可以动态的为某些对象添加一些额外的职责；
- Facade；
  - A single class that represents an entire subsystem
  - 门面模式：使用一个类表示某个子系统的入口；
- Flyweight；
  - A fine-grained instance used for efficient sharing 
  - 享元模式：高效的共享某些细粒度的对象实例；
- Private Class Data；
  - Restricts accessor/mutator access 
  - 限制访问器/存取器方法对私有类数据的访问；
- Proxy；
  - An object representing another object
  - 代理模式：使用一个代理类对象表示另一个对象；
  

## Behavioral Patterns（行为型模式）

此种设计模式主要涉及类的对象彼此之间是如何进行通信的。行为模式是那些与对象之间的通信最密切相关的模式。

主要由以下设计模式组成：

- Chain of responsibility；
  - A way of passing a request between a chain of objects 
  - 职责链模式：某些对象组成一条链状的结构，将要处理的请求传递给这条链，链中的每个节点会根据需要处理请求；
- Command；
  - Encapsulate a command request as an object 
  - 命令模式：将命令请求封装为对象；
- Interpreter；
  - A way to include language elements in a program 
  - 解释器模式：为某种语言定义一个文法，并用该文法解释语言中的语句；
- Iterator；
  - Sequentially access the elements of a collection
  - 迭代器模式：按照某种顺序访问集合中的元素；
- Mediator；
  - Defines simplified communication between classes 
  - 中介者模式：为多个类定义一种简单的方式进行通信（通过提供一个中介类）；
- Memento；
  - Capture and restore an object's internal state 
  - 备忘录模式：捕获和回复一个对象内部的各种状态；
- Null Object；
  - Designed to act as a default value of an object 
  - 对象的默认值；
- Observer；
  - A way of notifying change to a number of classes 
  - 观察者模式：定义了对象之间的一对多的依赖关系，当对象的状态发生变化时，可以通知其相关的依赖对象并更新相关状态；
- State；
  - Alter an object's behavior when its state changes 
  - 状态模式：当对象的状态发生变化时，随之更改该对象相关的行为；
- Strategy；
  - Encapsulates an algorithm inside a class
  - 策略模式：每个类都封装一种算法；
- Template Method；
  - Defer the exact steps of an algorithm to a subclass
  - 模板方法模式：将算法的特定步骤推迟到该算法的子类中去实现；
- Visitor；
  - Defines a new operation to a class without change 
  - 访问者模式：再不改变 class 的情况下为其增加一种新的行为；



# Abstract Factory

参考：

- https://refactoringguru.cn/design-patterns/abstract-factory

几种工厂的比对：

- https://refactoringguru.cn/design-patterns/factory-comparison

## Intent

- 提供一个接口用于创建 class 簇相关的对象，无需声明具体的子实现类；
- 提供一种层级结构（platforms -- products）：很多可能存在的 "platforms"，以及一套 "products" 的构建方式；
- 在抽象工厂模式中，不推荐使用 `new` 关键字创建对象，而是推荐使用工厂来创建；

## Problem

如果应用程序被设计为可移植的，它就必须要封装一些平台相关的依赖。这些 "platforms" 可能包括：windowing system，operating system、database、etc. 通常来讲，这种封装并不是预先设计好的，而是使用大量 if 语句来提供对不同 platforms 的支持。

## Discussion

提供了一定程度上的间接的抽象，这样在创建某个 families 及相关的依赖对象时就无需声明它们具体的 classes。"factory" 对象负责为整个 platform family 提供创建服务。Clients 从来不会直接创建 platform 对象，而是通过 factory 为它们做这件事。

这种机制使得交换产品族变得容易，因为工厂对象的特定类在应用程序中只出现一次。应用程序只需实例化抽象工厂的另一个具体实例，就可以批量替换整个产品系列。

由于工厂对象提供的服务非常多，且应用很广泛，所以通常将它实现为 Singleton。

## Structure

Abstract Factory 为每个 product 定义了一个 Factory Method，每个 Factory Method 中包含了 new 运算符、具体的子产品类、platform-specific（平台标识符），product classes（抽象产品类）。而每个 "platform" 则由 Factory 的派生类去进行建模。

## Example

Abstract Factory 的目的是为了提供一个接口用于创建和 families 相关的 objects，而无需声明 concrete classes。

以现实中 平台 和 产品 为例，特定的平台可以创建特定的产品：

平台抽象（Abstract Factory）：

```java
/**
 * mark interface: The class that implements this interface has the ability to create platform-specific objects
 */
public interface AbstractPlatform {
}
```

产品抽象：

```java
public interface Product {
    void introduce();
}
```

抽象产品 A：

```java
public interface AbstractProductA extends Product {
    default String getProductTag() {
        return "Product A";
    }
}
```

抽象产品 B：

```java
public interface AbstractProductB extends Product {
    default String getProductTag() {
        return "Product B";
    }
}
```

具体产品：

（1）平台 A 下的产品 A：

```java
public class ProductAPlatformA implements AbstractProductA {
    public void introduce() {
        System.out.printf("Platform: A, %s%n", this.getProductTag());
    }
}
```

（2）平台 A 下的产品 B：

```java
public class ProductBPlatformA implements AbstractProductB {
    public void introduce() {
        System.out.printf("Platform: A, %s%n", this.getProductTag());
    }
}
```

（3）平台 B 下的产品 A：

```java
public class ProductAPlatformB implements AbstractProductA {
    public void introduce() {
        System.out.printf("Platform: B, %s%n", this.getProductTag());
    }
}
```

（4）平台 B 下的产品 B：

```java
public class ProductBPlatformB implements AbstractProductB {
    public void introduce() {
        System.out.printf("Platform: B, %s%n", this.getProductTag());
    }
}
```

平台实现 A：

```java
public class PlatformA implements AbstractPlatform {
    
    // 如果工厂对象的构建需要其他资源才可以, 则可以考虑将工厂对象做成单例对象
    // 本例只演示最简单的用法: 即提供静态方法用于创建具体的产品
    
    public static AbstractProductA makeProductA() {
        return new ProductAPlatformA();
    }
    
    public static AbstractProductB makeProductB() {
        return new ProductBPlatformA();
    }
    
}
```

平台实现 B：

```java
public class PlatformB implements AbstractPlatform {

    // 如果工厂对象的构建需要其他资源才可以, 则可以考虑将工厂对象做成单例对象
    // 本例只演示最简单的用法: 即提供静态方法用于创建具体的产品
    
    public static AbstractProductA makeProductA() {
        return new ProductAPlatformB();
    }
    
    public static AbstractProductB makeProductB() {
        return new ProductBPlatformB();
    }
    
}
```

测试客户端：

```java
public class AbstractFactoryTestClient {
    public static void main(String[] args) {
        // Platform A:
        PlatformA.makeProductA().introduce();
        PlatformA.makeProductB().introduce();
        
        // Platform B:
        PlatformB.makeProductA().introduce();
        PlatformB.makeProductB().introduce();
    }
}
```

预期输出：

```
Platform: A, Product A
Platform: A, Product B
Platform: B, Product A
Platform: B, Product B
```

## Rules of thumb

有时候 creational patterns 是可以替换的：比如某些条件下用 Prototype 或 Abstract Factory 都行；

有些时候它们也可以是互补的：

- Abstract Factory 中可能存储一组 Prototypes，此时调用工厂方法去创建具体的产品就会调用具体产品原型的 clone 方法返回新的对象；
- Builder 可以使用其他 patterns 的实现来创建不同的 component；
- Abstract Factory、Builder 以及 Prototype 都可以在它们的实现中使用 Singleton；

Abstract Factory、Builder 和 Prototype 定义了一个工厂对象，它负责了解和创建产品对象的类，并使其成为系统的一个参数：

- Abstract Factory 使用 factory object 创建一些类的 objects；
- Builder 使用 factory object 利用复杂的 protocol 去增量的创建对应的复杂的产品；
- Prototype 使用 factory object（aka prototype）通过 copy prototype object 去构建产品；

Abstract Factory 的实现通常会结合 Factory Methods 模式，同时它们各自的实现都可以结合 Prototype；

Abstract Factory 也可以作为 Facade 模式的替代品用于隐藏 platform-specific classes；

Builder 专注于按照特定的步骤去构建复杂的对象。Abstract Factory 则强调 product objects 是具有 family 的（包括 simple 和 complex）。Builder 将对象的返回最为最终操作，但是对于 Abstract Factory 而言，调用方法就会立即返回 product object。

通常，在设计之初会选择 Factory Methods 模式（复杂性较低、更容易定制化、但是会定义很多子类），然后随着项目的不断推进，就需要更加灵活的机制，此时会逐渐向 Abstract Factory、Prototype 或者 Builder（更加灵活、更加复杂）发展。



# Adapter

参考：

- https://refactoringguru.cn/design-patterns/adapter

## Intent

- 将某个类提供的接口转换为其他客户端接口所期望的接口；适配器就是为了让两个不兼容的接口能够在一起工作而提出的设计模式；
- 将一个已经存在的 class 包装为一个新的接口；
- 将一个旧的 component 接入到新的系统中；

## Problem

一个 "off the shelf"（现成的）组件提供的接口需要重复使用，但是它和正在开发的新系统的某些设计理念或者架构不兼容。

## Discussion

Reuse 一直是一个痛苦的、不容易理解的，其中一个原因是设计新东西的同时又要重复使用旧的东西。新旧事物之间总有些不太对劲的地方。

这就像把一个新的三脚插头插入一个旧的两脚墙壁插座的问题——某种适配器或中介是必要的。

Adapter 设计模式通过提供一个中间层抽象，比如 translates or maps 从而将旧的组件接入新的系统中。Clients 调用 Adapter object 的方法时，内部会将请求重定向到旧的组件中。此策略既可以通过继承（inheritance）实现，也可以通过聚合（aggregation）实现。

Adapter 为一个已经存在的 class 提供 wrapper 或者 modifier，也就是这个 class 的 different 或者 translate view；

## Structure

考虑这样的场景，一个旧的 Rectangle component 的 display 方法接受参数为 `x, y, w, h` 即左上角坐标和宽高，但是现在 client 期望传入左上角坐标和右下角坐标，此时可以通过为旧的 Rectangle 组件添加一个 Adapter Object 来解决不协调问题。

## Example

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

## Rules of thumb

Adapter 让某些事物在它们被设计完成之后进行工作，而 Bridge 则让它们提前工作；

（Adapter makes things work after they're designed; Bridge makes them work before they are. ）

Bridge 是预先设计好以便让 abstraction 和 implementation 分离。而 Adapter 则将两个类进行改造以便让它们能在一起工作。

- Adapter 为其 subject 提供一个不同的 interface；

- Proxy 提供的则是相同的 interface；
- Decorator 提供的是增强的 interface；

Adapter 用于更改一个已存在的对象的接口。Decorator 在不改变其接口的情况下增强对象的功能。因此，对于应用程序来说，Decorator 比 Adapter 更透明。同时，Decorator 支持递归组合（recursive composition），这是纯粹的 Adapter 所不能做到的。

Facade 定义了一个新的接口，而 Adapter 则复用一个旧的接口。请记住，Adapter 使两个现有接口一起工作，而不是定义一个全新的接口。

# Bridge

参考：

- https://refactoringguru.cn/design-patterns/bridge

## Intent

- 将 abstraction 和该抽象的 implementation 解耦，这样它们就可以分离了；
- 用继承体系来扩展新的接口，同时隐藏每个接口具体的层次实现；
- 要比 encapsulation 更进一步，达到 insulation（绝缘）；

## Problem

"Hardening of the software arteries" 通过使用抽象基类的子类来提供可选的实现，这样在 compile-time 就将 interface 和其 implementation 进行绑定。抽象和实现不能独立地扩展或组合。

## Motivation

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

## Discussion

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

## Structure

Client 并不想去处理和 platform-dependent 相关的细节，使用 Bridge 模式可以将其中的复杂操作封装在一个 abstraction "wrapper" 下面；

Bridge 强调从 "implementation" abstraction 中识别和解耦 "interface" abstraction。

## Example

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

## Check List

（1）需要判断当前 domain 中存在哪两个维度可以构成正交关系（在上面的例子中开关的种类和具体事物的开关构成一个正交关系），这两个独立的概念类似于：abstraction/platform、or domain/infrastructure，or front-end/back-end，or interface/implementation；

（2）关注点分离设计： what does the client want, and what do the platforms provide. 

（3）Design a platform-oriented interface that is minimal, necessary, and sufficient. Its goal is to decouple the abstraction from the platform.

（4）Define a derived class of that interface for each platform. 

（5）Create the abstraction base class that "has a" platform object and delegates the platform-oriented functionality to it. 

（6）Define specializations of the abstraction class if desired. 

## Rules of thumb

Adapter makes things work after they're designed; Bridge makes them work before they are. 

Adapter 模式可以让一个已经设计好的事物接入新的系统并顺利工作，而 Bridge 模式在设计之初就想好了后面它们该如何工作；

（简而言之，适配器模式对接的是一个过去设计的可能有点问题的组件，而桥接者模式的目的是为了设计一个灵活度高、扩展性好的组件）

Bridge 在设计时将抽象和实现分离，各自可以独立扩展。Adapter 则是让两个不相关的接口可以一起工作。

State、Strategy、Bridge（某种程度上也包括 Adapter）具有相似的解决方案结构。它们都是基于 "handle/body" idiom 的。但是它们的意图不同，因为这些设计模式是为了解决不同的问题而提出的。

从结构上看 State 和 Bridge 是一样的（唯一的区别就在于 Bridge 中存在层级结构，而 State 中只有一层）。这两个模式使用了相同的结构去处理不同的问题：

- 相同的结构是指：State 中对象的 behavior 和 state，Bridge 中的 implementation 和 abstraction；

- State 允许对象的 behavior 随着其 state 的改变而改变，而 Bridge 则是从其 implementation 中将 abstraction 中解耦出去，这样抽象和实现就可以彼此分离。

If interface classes delegate the creation of their implementation classes (instead of creating/coupling themselves directly), then the design usually uses the Abstract Factory pattern to create the implementation objects.

# Builder

参考：

- https://refactoringguru.cn/design-patterns/builder

## Intent

- 将复杂对象的 construction 和其 representation 分离，这样使用相同的构建过程就可以创造不同的 representations；
- Parse a complex representation, create one of several targets.

## Problem

应用程序需要创建一个复杂聚合中的各种元素。The specification for the aggregate exists on secondary storage and one of many representations needs to be built in primary storage.



## Discussion

Separate the algorithm for interpreting (i.e. reading and parsing) a stored persistence mechanism (e.g. RTF files) from the algorithm for building and representing one of many target products (e.g. ASCII, TeX, text widget). The focus/distinction is on creating complex aggregates.

The "director" invokes "builder" services as it interprets the external format. The "builder" creates part of the complex object each time it is called and maintains all intermediate state. When the product is finished, the client retrieves the result from the "builder". 

Affords finer control over the construction process. Unlike creational patterns that construct products in one shot, the Builder pattern constructs the product step by step under the control of the "director".



## Structure

Builder 模式中存在两种角色："Director" 用于调用 "Builder" 来创建不同的小组件，最后将所有小组件组装为一个复杂的对象。

考虑这样的场景："Reader" 读取输入并进行解析，然后调用 "Converter" 构造 table、paragraph、list 等文档组件，最后组装成富文本文件（RTF files）输出。



## Example

The Builder pattern separates the construction of a complex object from its representation so that the same construction process can create different representations.

这种模式非常适合快餐店中的点餐服务，比如说 children's meals. Children's meals typically consist of a main item, a side item, a drink, and a toy (e.g., a hamburger, fries, Coke, and toy dinosaur).  Note that there can be variation in the content of the children's meal, but the construction process is the same. 

Whether a customer orders a hamburger, cheeseburger, or chicken, the process is the same. The employee at the counter directs the crew to assemble a main item, side item, and toy. These items are then placed in a bag. The drink is placed in a cup and remains outside of the bag. This same process is used at competing restaurants. 

这里存在三种角色，顾客 "Customer（Client）" 告知收银员 "Cashier（director）" 要点的儿童菜单，收银员告诉工作人员 "Restaurant crew（builder）" 套餐内容，工作人员制作好套餐后交给收银员，收银员将套餐交给客户。

> Builder

Builder 接口：

```java
/**
 * 儿童套餐的通用制作步骤 <br/>
 * 这里为了做简单的演示, 在套餐中只定义了两种食物。
 */
public interface ChildrenMealBuilder {
    
    ChildrenMealBuilder setMainItem(MainItem main);
    
    ChildrenMealBuilder setDrink(Drink drink);
    
    ChildrenMeal getMeal();
    
}
```

Builder 接口的简单实现：

```java
/**
 * 简单套餐 Builder
 */
public class SimpleMealBuilder implements ChildrenMealBuilder {
    
    private ChildrenMeal meal;

    public SimpleMealBuilder() {
        this.meal = new ChildrenMeal();
    }

    @Override
    public ChildrenMealBuilder setMainItem(MainItem main) {
        this.meal.setMain(main);
        return this;
    }

    @Override
    public ChildrenMealBuilder setDrink(Drink drink) {
        this.meal.setDrink(drink);
        return this;
    }

    @Override
    public ChildrenMeal getMeal() {
        return this.meal;
    }
    
}
```

> Product

儿童套餐：

```java
/**
 * ChildrenMeal 就是最终的成果
 */
public class ChildrenMeal {
    
    private MainItem main;
    
    private Drink drink;
    
    public void desc() {
        System.out.printf("children meal: [%s, %s]%n", this.main.getName(), this.drink.getName());
    }

    public MainItem getMain() {
        return main;
    }

    public void setMain(MainItem main) {
        this.main = main;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }
}
```

> Components

主食接口抽象：

```java
public interface MainItem {
    String getName();
}
```

饮料接口抽象：

```java
public interface Drink {
    String getName();
}
```

相关实现（演示使用，具体虚结合实际情况）：

```java
public class SimpleMainItem implements MainItem {
    @Override
    public String getName() {
        return "simple main item";
    }
}
```

```java
public class SpecialMainItem implements MainItem {
    @Override
    public String getName() {
        return "special main item";
    }
}
```

```java
public class SimpleDrink implements Drink {
    @Override
    public String getName() {
        return "simple drink";
    }
}
```

```java
public class SpecialDrink implements Drink {
    @Override
    public String getName() {
        return "special drink";
    }
}
```

> Director

Director 用于控制 Builder：

```java
/**
 * Director 中封装了一些常用的构造复杂对象的模板, 注意 Director 不是必须的 <br/>
 * 如果需要高度定制化, Client 可以直接调用对应的 Builder 来构建自己需要的产品
 */
public class Director {

    /**
     * 制作 simple 套餐
     * @param builder
     */
    public void instructMakeSimpleMeal(ChildrenMealBuilder builder) {
        builder.setMainItem(new SimpleMainItem())
                .setDrink(new SimpleDrink());
    }

    /**
     * 制作 special 套餐
     * @param builder
     */
    public void instructMakeSpecialMeal(ChildrenMealBuilder builder) {
        builder.setMainItem(new SpecialMainItem())
                .setDrink(new SpecialDrink());
    }
}
```

> Client

测试类：

```java
public class BuildTestClient {
    public static void main(String[] args) {
        Director director = new Director();
        
        // 使用 Director 组装 SimpleMealBuilder
        ChildrenMealBuilder builder1 = new SimpleMealBuilder();
        director.instructMakeSimpleMeal(builder1);
        ChildrenMeal simpleMeal = builder1.getMeal();
        
        simpleMeal.desc();
        
        // 使用 Director 组装 SpecialMealBuilder
        ChildrenMealBuilder builder2 = new SimpleMealBuilder();
        director.instructMakeSpecialMeal(builder2);
        ChildrenMeal specialMeal = builder2.getMeal();
        
        specialMeal.desc();
        
        // 直接使用 Builder 根据需要组装套餐
        SimpleMealBuilder builder3 = new SimpleMealBuilder();
        builder3.setMainItem(new SpecialMainItem())
                .setDrink(new SimpleDrink());
        ChildrenMeal customizedMeal = builder3.getMeal();
        
        customizedMeal.desc();
    }
}
```

输出：

```
children meal: [simple main item, simple drink]
children meal: [special main item, special drink]
children meal: [special main item, simple drink]
```

## Rules of thumb

