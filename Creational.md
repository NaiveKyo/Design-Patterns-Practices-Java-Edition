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