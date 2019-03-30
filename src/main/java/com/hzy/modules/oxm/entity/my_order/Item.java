package com.hzy.modules.oxm.entity.my_order;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/28 20:42
 * @Description version 1.0
 */
public class Item {

    public String _reference;
    public int    _quantity;
    public float  _unitPrice;
    public String _description;

    public Item() {
    }

    public Item(String _reference, int _quantity, float _unitPrice, String _description) {
        this._reference = _reference;
        this._quantity = _quantity;
        this._unitPrice = _unitPrice;
        this._description = _description;
    }

    public String get_reference() {
        return _reference;
    }

    public void set_reference(String _reference) {
        this._reference = _reference;
    }

    public int get_quantity() {
        return _quantity;
    }

    public void set_quantity(int _quantity) {
        this._quantity = _quantity;
    }

    public float get_unitPrice() {
        return _unitPrice;
    }

    public void set_unitPrice(float _unitPrice) {
        this._unitPrice = _unitPrice;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }
}
