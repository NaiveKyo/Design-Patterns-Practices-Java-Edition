# Overview

参考：

- https://www.tutorialspoint.com/design_pattern/design_pattern_overview.htm
- https://refactoring.guru/
- https://refactoringguru.cn/

在软件工程中，设计模式是针对软件设计中常见问题的通用解决方案。设计模式不是可以直接转换为代码的成品设计。它是解决某类问题的描述或模板，需要结合项目实际情况来使用它们。

良好的软件设计需要在开发最初就要考虑到后期可能遇到的问题，而利用设计模式可以避免一些细节问题，此类问题一般会在项目后期导致一些不必要的麻烦。同时设计模式也可以提高代码的可读性。

通常，人们只了解如何将特定的软件设计技术应用于特定的问题，但是这些技术很难应用于更广泛的问题。设计模式提供通用的解决方案，并且不与特定的问题细节相关，仅仅作为一份描述或模板。

此外，模式允许开发人员使用众所周知的、易于理解的软件交互名称进行通信。随着时间推移，通用的设计模式会不断改进。

<font style='color:green'>注意：学习设计模式之前应该对面向对象编程（抽象、封装、继承、多态）以及 UML 有大致的了解，明确几种关系及其箭头标识（继承、实现、依赖、关联、聚合、组合）</font>

# Pattern and Algorithm

模式和算法都是人们针对特定问题的典型解决方案，只不过在概念上有一些不同：

- 算法总是明确定义达成特定目标所需要的一系列步骤；
  - 提供了达成目标所需要的明确步骤；
- 模式是对解决方案的更高层次的描述，同一模式在不同的程序中实现的代码可能会不一样；
  - 模式类似蓝图，可以看到最终结果以及模式的功能，但需要自己确定实现步骤；

通常模式包含以下内容：

- 意图（Intent）：简要的描述问题和解决方案；
- 动机（Motivation）：进一步解释问题并说明模式会如何提供解决方案；
- 结构（Structure）：展示模式的各个部分以及它们之间的关系；
- 不同语言的实现（Example）：提供不同语言的实现版本；
- 实用细节（Rules of thumb）：提供一些信息，诸如模式的适用性、实现步骤以及与其他模式的关系；



# Category

主流的设计模式主要分为三类：

## Creational Patterns

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

## Structural Patterns

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
  

## Behavioral Patterns

此种设计模式主要涉及类的对象彼此之间是如何进行高效沟通和职责委派。行为模式是那些与对象之间的通信最密切相关的模式。

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



# Design Principles

（1）封装变化的内容

将程序中变化的部分抽取出来，将其和不变的内部分隔开，这样如果未来需要变动某些内容，对程序造成的影响就会很小；

具体表现为：方法和类层面的封装。

（2）面向接口开发，而不是面向实现；依赖于抽象基类，而不是具体类

充分利用 OOP 编程中多态的特性可以降低类之间的耦合度；

（3）组合优于继承

如果要扩展一个已有的类，继承是最好的选择，但是这种情况适合程序中存在大量类的情况，将相似类的相同部分抽取为抽象基类，子类去继承它，但是继承也有一些限制：

- 子类不能减少超类的接口（这里的接口指的是类的行为即方法）；
- 重写方法时，必须兼容基类中该方法对应的版本；
- 继承打破了超类的封装性，因为子类可以访问父类的内容；
- 子类与超类紧密耦合，一旦修改了超类，子类必定受到影响；
- 继承可能会导致类膨胀，通常继承是在单个维度中存在，如果存在需要两个维度的情况，就会导致大量的类被创建；

组合（UML 中的强关联关系）是代替继承的一个方案，当然也适用于聚合。

组合可以利用多个类的功能来共同完成要实现的目标。

# SOLID Principles

SOLID 是让软件设计更易于理解、更加灵活和更易于维护的五个原则的简称。

注意开发时不必一味遵循这些原则，根据实际情况来即可。

## Single Responsibility Principle

S 单一职责原则：简而言之，一个类或方法只需关注少量的功能特性即可，职责不应过于繁重。



## Open/Closed Principle

O 开闭原则：对于扩展，类应该是 "开放" 的，对于修改，类则应是 "封闭" 的。

简而言之，如果要为某个类增加新的功能，最好通过继承来扩展它，而不是直接修改该类中的代码。



## Liskov Substitution Principle

L 里氏替换原则：在不修改客户端代码的情况下，将子类对象做为参数传递给对应的方法，且该方法接受的参数类型是该对象的超类。

简而言之，通过继承重写基类的方法，同时还需要兼容基类，而不是完全替换掉基类的方法。

里氏替换原则中提出了多条有关继承中最好遵循的约束，可以查阅相关信息；

## Interface Segregation Principle

I 接口隔离原则：尽量缩小接口的范围，使得客户端不必实现其不需要的行为。

简而言之，不必要在基类中设置大量的方法，可以将其细化拆分为多个接口，充分利用单继承多实现的特性。

注意不要过度使用该原则，因为创建的接口越多，程序就会变得越复杂。



## Dependency Inversion Principle

D 依赖倒置原则：高层次的类不应该依赖于低层次的类。两者都应该依赖于抽象接口。抽象接口不应依赖于具体实现，具体实现应该依赖于抽象接口。

关于类的层次划分：

- 低层次的类：通常实现基础操作，比如磁盘操作、网络传输、连接数据库等等；
- 高层次的类：包含复杂的业务逻辑，这里逻辑中利用低层次类提供的功能来完成业务；

在开发产品时，通常会先设计低层次的类，然后才会开发高层次的类。这是因为由于低层次的东西没有实现或不确定，因此无法确定高层次的类能够实现哪些功能。如果采用这种模式，业务逻辑类可能会更加依赖于底层原语类。

依赖倒置原则中建议改变这种依赖方式：高层次的类依赖于某些接口，而低层次的类则实现这些接口，切换不同的低层次接口实现类，对高层次类的影响将会变小。此时接口就依赖于高层次类完成业务所需要的功能，而低层次类依赖于接口中定义的业务逻辑，从而倒置了之前的依赖关系。



# Creational Patterns

创建型模式通过提供创建对象的机制来提高代码的灵活性和可复用性。



## Factory Method

工厂方法，又称 Virtual Constructor；

在父类中定义一个创建对象的方法，允许子类决定实例化对象的类型。

### Problem

假设要开发一款物流运输系统，早期程序仅支持卡车陆运，所有的业务逻辑都和卡车类强耦合，如果后续要追加新的运输方式则很难复用已有的代码，需要新增很多代码以适配新的功能，

### Solution

Factory Method 模式可以作为此类问题的一种解决方案，即使用特殊的工厂方法替代直接使用 new 运算符创建对象，工厂方法返回的对象通常称为 "产品"。

回顾前面的物流问题，此时可以抽取物流基类 `Logistics`，在该基类中定义创建物流的工厂方法，然后提供两个实现类：`RoadLogistics`  和 `SeaLogistics` 分别对应陆运和海运两种方式。而每种运输方式又可以有不同的具体实现，比如陆运有卡车，海运有轮船，运输货物的载体可以看作 "产品"，对其进行抽象，可以建立接口 `Transport` 定义运输工具的通用运输方法，同时提供子类实现该接口 `Truck`、`Ship`。

最终结构就是这样的：卡车走陆路运输货物，轮船走海路运输货物，如果想要扩展新的运输方式，只需增加几个实现类即可。

具体代码如下：

工厂：

```java
/**
 * 抽象简单工厂基类: 定义了物流工厂创建物流方式的通用方法
 */
public abstract class Logistics {

    /**
     * 通常情况下客户端不关系具体的物流实现 <br/>
     * 客户端认为只需调用此方法传入具体的货物即可进行运输
     */
    public void planDelivery() {
        Transport t = this.createTransport();
        t.delivery();
    }

    /**
     * 定义创建产品的抽象方法, 具体的产品实现由工厂实现子类决定
     * @return 具体的运输方式实现
     */
    public abstract Transport createTransport();
    
}

/**
 * 具体工厂实现类: 陆路运输方式
 */
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

/**
 * 具体工厂实现类: 海路运输方式
 */
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
```

产品：

```java
/**
 * 产品接口: 定义物流使用的运输载体的通用行为
 */
public interface Transport {

    /**
     * 所有运输工具都能够运输货物
     */
    void delivery();
    
}

/**
 * 产品具体实现类: 卡车
 */
public class Truck implements Transport {
    @Override
    public void delivery() {
        System.out.println("使用卡车走陆路运输...");
    }
}

/**
 * 产品具体实现类: 轮船
 */
public class Ship implements Transport {
    @Override
    public void delivery() {
        System.out.println("使用轮船走海路运输...");
    }
}
```

测试客户端：

```java
/**
 * 工厂方法模式在物流体系中的实现, 对应的测试 Client
 */
public class LogisticsFactoryMethodTestClient {
    public static void main(String[] args) {
        Logistics roadLogistics = new RoadLogistics();
        Logistics seaLogistics = new SeaLogistics();
        
        // 实际环境中这里应该传递要运输的 "货物"
        roadLogistics.planDelivery();
        seaLogistics.planDelivery();
    }
}
```

### Structure

参加前面的例子，我们对工厂方法有了一个了解，在该设计模式中存在以下几类角色：

- Creator （工厂抽象类）
  - ConcreteCreatorA（具体工厂实现 A）
  - ConcreteCreatorB（具体工厂实现 B）
  - 。。。。。。
- Product（产品接口）
  - ConcreteProductA（具体产品 A）
  - ConcreteProductB（具体产品 B）

（1）产品 Product：一般会使用接口定义，定义产品所具备的通用行为。对于所有由 Creator 及其子类实现所 new 出来的 Product 对象，这些接口（行为）都是通用的。

（2）具体产品 ConcreteProduct：产品接口的不同实现；

（3）创建者 Creator：抽象基类中声明返回产品对象的工厂方法。该方法返回的对象类型必须和产品接口相匹配；

我们可以将其声明为抽象类，并定义抽象方法声明子类必须提供产品对象，或者定义默认的方法创建默认的产品对象。一般来说 Creator 中包含一些和产品相关的核心业务逻辑，而工厂方法则将这些逻辑处理从具体的产品类中分离出来。

（4）具体创建者 ConcreteCreator：重写基础工厂方法，返回不同的产品类型；

<font style='color:green'>注意：每一次调用工厂方法时，也不一定会每次都用 new 出新的对象，也可以返回缓存、对象池或者其他来源的以及创建好的对象。</font>这就涉及到设计模式的组合了。

### Example

下面演示如何使用工厂方法开发跨平台 UI 界面组件，假设我们要开发一个 Dialog（对话框）UI 组件，Dialog 中有 Button 按钮组件，在不同的操作系统下这些组件外观略有不同，但其功能保持一致，使用工厂方法模式可以避免为每个平台系统重写对话框逻辑。

工厂 Dialog：

```java
public abstract class Dialog {

    /**
     * 通常 Creator 的职责不仅仅是创建产品, 同时还包括核心业务逻辑, 这些业务逻辑依赖于具体的产品
     */
    public void render() {
        // 调用此方法渲染出一个 Dialog, 假设此对话框中存在一个按钮用于关闭该 Dialog
        Button button = this.createButton();
        // 假设点击按钮就会关闭对话框, 此处应传入点击事件回调
        button.onClick();
        button.render();
    }
    
    public abstract Button createButton();
    
}

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}

public class WebDialog extends Dialog {
    @Override
    public Button createButton() {
        return new HTMLButton();
    }
}
```

Button 产品：

```java
public interface Button {
    
    // 渲染该 Button
    void render();
    
    // Button 点击事件
    void onClick();
    
}

public class WindowsButton implements Button {
    @Override
    public void render() {
        
    }

    @Override
    public void onClick() {

    }
}

public class HTMLButton implements Button {
    @Override
    public void render() {
        
    }

    @Override
    public void onClick() {

    }
}
```

测试 Client：

```java
public class UIFactoryMethodTestClient {
    
    private static Dialog dialog;
    
    public static void main(String[] args) {
        String osType = "";
        
        if ("windows".equals(osType)) {
            dialog = new WindowsDialog();
        } else if ("web".equals(osType)) {
            dialog = new WebDialog();
        } else {
            // handle error
        }
        
        dialog.render();
    }
}
```

如果使用此种模式继续开发其他 UI 组件，比如其他平台的独有 Dialog 和 Button，该模式就会逐渐向 Abstract Factory 抽象工厂模式发展。

### Scenario

工厂方法模式可以适用这些场景：

（1）在开发时无法预知对象确切的类别及其依赖关系时，可以使用工厂方法；

注意需要知道该对象的抽象接口，此时工厂方法可以将创建产品的代码和实际使用产品的代码分离。

（2）开发的框架中为用户预留扩展机制，允许用户扩展内部组件；

通常情况下可以使用继承扩展某个框架的默认行为，但是如何让框架识别并使用我们创建的子类呢？

解决方案是将框架中构造各个组件的代码集中到单个工厂方法中，并在继承该组件之外允许任何人重写该方法，注意这个组件应该属于该框架的启动类之一，客户端会和该类交互。

（3）复用现有的对象节省系统资源；

在处理大型资源密集型对象（比如数据库连接、文件系统和网络资源）时，经常有此类需求；



### Advantage/Disadvantage

优点：

- 可以避免 Creator 和 Product 之间紧密耦合；
- 单一职责原则：创建产品的代码下发到具体的 Creator 实现类中，代码更容易维护；
- 开闭原则：无需更改现有客户端的代码就可以引入新的产品类型；

缺点：

- 使用工厂方法模式会引入很多子类，代码可能会变得更加复杂。

###  Rules of thumb

- 很多项目在初期会使用 Factory Method，随后演进为使用 Abstract Factory、Prototype 或 Builder（更加灵活但是也更加复杂）；
- Abstract Factory 通常基于一组 Factory Method，但是也可以使用 Prototype 模式来生成这些类的方法；
- 可以同时使用 Factory Method 和 迭代器（Iterator）来让子类集合返回不同类型的迭代器，并使得迭代器和集合相匹配；
- Prototype 并不是基于继承的，因此没有继承的缺点。另一方面，原型需要对被复制的对象进行复杂的初始化。工厂方法基于继承，但是它不需要复杂的初始化工作；
- Factory Method 是 Template Method（模板方法）的一种特殊形式。同时 Factory Method 可以作为一个大型模板方法中的一个步骤；



## Abstract Factory

几种工厂的比对：

- https://refactoringguru.cn/design-patterns/factory-comparison

抽象工厂可以创建一系列相关的对象，而无需指定其具体实现类。

### Intent

- 提供一个接口用于创建 class 簇相关的对象，无需声明具体的子实现类；
- 提供一种层级结构（platforms -- products）：很多可能存在的 "platforms"，以及一套 "products" 的构建方式；
- 在抽象工厂模式中，不推荐使用 `new` 关键字创建对象，而是推荐使用工厂来创建；



### Problem

如果应用程序被设计为可移植的，它就必须要封装一些平台相关的依赖。这些 "platforms" 可能包括：windowing system，operating system、database、etc. 通常来讲，这种封装并不是预先设计好的，而是使用大量 if 语句来提供对不同 platforms 的支持。



### Structure

Abstract Factory 为每个 product 定义了一个 Factory Method，每个 Factory Method 中包含了 new 运算符、具体的子产品类、platform-specific（平台标识符），product classes（抽象产品类）。而每个 "platform" 则由 Factory 的派生类去进行建模。



### Example

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

### Rules of thumb

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



## Builder

生成器模式能够分步骤创建复杂的对象，同时该模式还允许使用相同的创建代码生成不同类型和形式的对象。



### Intent

- 将复杂对象的 construction 和其 representation 分离，这样使用相同的构建过程就可以创造不同的 representations；
- Parse a complex representation, create one of several targets.

### Problem

应用程序需要创建一个复杂聚合中的各种元素。The specification for the aggregate exists on secondary storage and one of many representations needs to be built in primary storage.



### Discussion

Separate the algorithm for interpreting (i.e. reading and parsing) a stored persistence mechanism (e.g. RTF files) from the algorithm for building and representing one of many target products (e.g. ASCII, TeX, text widget). The focus/distinction is on creating complex aggregates.

The "director" invokes "builder" services as it interprets the external format. The "builder" creates part of the complex object each time it is called and maintains all intermediate state. When the product is finished, the client retrieves the result from the "builder". 

Affords finer control over the construction process. Unlike creational patterns that construct products in one shot, the Builder pattern constructs the product step by step under the control of the "director".



### Structure

Builder 模式中存在两种角色："Director" 用于调用 "Builder" 来创建不同的小组件，最后将所有小组件组装为一个复杂的对象。

考虑这样的场景："Reader" 读取输入并进行解析，然后调用 "Converter" 构造 table、paragraph、list 等文档组件，最后组装成富文本文件（RTF files）输出。



### Example

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



## Prototype

原型模式又称：克隆、Clone，能够复制已有的对象，而又无需使代码依赖它们所属的类。



### Problem

假如你有一个对象，希望能够对其进行复制获得一个完全一样的对象。

这个过程中会遇到如下问题：首先得知道这个对象所属的类，其次需要能够访问其 private 属性；

### Solution

Prototype 模式将克隆的过程委派给被克隆的实际对象。该模式需要为所有支持克隆的对象声明一个通用接口，实现了该接口的类就可以支持被克隆。通常情况下，这个接口中仅包含一个 `clone` 方法。

支持克隆的对象即为 Prototype（原型）；



### TODO

关于原型模式提出的这种 clone 机制过程简单明了，但是在不同语言中的实现不同，后面可以仔细分析该模式在 Java 语言中的实现：

- 简单的根据属性一对一赋值实现 clone；
- 利用 IO 流序列化 clone；
- 利用反射机制实现 clone；



### Rules of thumb

- 很多设计工作初期会使用工厂方法，随后演进为使用抽象工厂、原型或生成器；
- Prototype 可以用来保存 Command 模式的历史记录；
- 大量使用 Composite（组合）模式和 Decorator（装饰器）模式的设计通常可以通过使用 Prototype 获取某些好处，借助原型复制复杂的结构，而非从零开始构造；
- 有时候 Prototype 可以作为 Memento（备忘录）的一个简化版本，但是要求在历史记录中存储的对象的状态比较简单，不需要链接其他外部资源，或者链接可以很方便的重建。
- 抽象工厂、生成器和原型都可以使用单例实现；



## Singleton

单例模式保证一个类只有一个实例，并提供一个访问该实例的全局节点。

### Intent

主要目的是为了保护某些占用共享资源的重要对象。一般情况下构造这些对象的代价都较高。

所有单例的实现都包括下面两个步骤：

1. 私有化默认构造函数，禁止在单例 class 对象之外使用 new 运算符构造该对象；
2. 提供一个静态构造方法，并将其保存到一个静态成员中，后续所有调用该函数的行为都只会获取到该缓存对象。（<font style='color:green'>通常这个步骤会结合编程语言的相关特性，比如在 Java 中会考虑并发操作，从而保证单例只会被初始化一次</font>）



### Example

以 Java 语言为例，这里仅列出一种单例的实现方式，更多信息可自行查阅相关资料：

借助 Java 静态类初始化过程中加锁的特点来构造单例：

```java
public final class Singleton {

    private Singleton() {
    }

    private static class LazyInitialization {
        private static Singleton instance = null;
        static {
            instance = new Singleton();
        }
    }
    
    public static Singleton getInstance() {
        return LazyInitialization.instance;
    }
    
}
```

测试类：

```java
public class SingletonTestClient {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            service.execute(() -> {
                System.out.println(Singleton.getInstance());
            });
        }

        TimeUnit.SECONDS.sleep(3);
    }
}
```

期望输出：

```
io.naivekyo.Singleton.Singleton@10351c94
io.naivekyo.Singleton.Singleton@10351c94
io.naivekyo.Singleton.Singleton@10351c94
// ..................
```

### Rules of thumb

- Facade 类通常可以转换为 Singleton 类，大部分情况下一个 Facade 类就足够了；
- 如果可以将对象的所有共享状态简化为一个享元对象，那么 Flyweight 和 Singleton 就类似了，但是这种模式有本质上的不同之处：
  - 只有一个单例实体，但是享元类可以有多个实体，各个实体内部的状态也不一样；
  - 单例对象可以是可变的，但是享元对象是不可变的；
- 抽象工厂、生成器、原型都可以通过单例实现。







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