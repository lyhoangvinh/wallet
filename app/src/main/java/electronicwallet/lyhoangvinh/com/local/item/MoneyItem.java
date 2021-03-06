package electronicwallet.lyhoangvinh.com.local.item;

import java.util.List;

import electronicwallet.lyhoangvinh.com.base.interfaces.Item;
import electronicwallet.lyhoangvinh.com.local.model.Money;

public class MoneyItem implements Item {
    private List<Money> moneys;

    public MoneyItem(List<Money> moneys) {
        this.moneys = moneys;
    }

    public List<Money> getMoneys() {
        return moneys;
    }
}
