package io.naivekyo.structural.Flyweight.flyweight;

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
