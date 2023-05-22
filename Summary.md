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