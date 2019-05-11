package utils.DBUtil;

/**
 * @Author hzy
 * @Date 2019/5/9 20:10
 * @Description
 */
public class Column {

    private int index;
    private String name;
    private int type;
    private String typeName;
    private int scale;
    private int precision;
    private String className;
    private String label;
    private int displaySize;

    public Column() {
    }

    public Column(int index, String name, int type, String typeName, int scale, int precision, String className, String label, int displaySize) {
        this.index = index;
        this.name = name;
        this.type = type;
        this.typeName = typeName;
        this.scale = scale;
        this.precision = precision;
        this.className = className;
        this.label = label;
        this.displaySize = displaySize;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(int displaySize) {
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {
        return "Column{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", scale=" + scale +
                ", precision=" + precision +
                ", className='" + className + '\'' +
                ", label='" + label + '\'' +
                ", displaySize=" + displaySize +
                '}';
    }
}
