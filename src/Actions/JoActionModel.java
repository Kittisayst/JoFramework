package Actions;

import Components.JoCombobox;
import Components.JoTable;

public interface JoActionModel {

    public void load(String value) throws Exception;

    public int Insert() throws Exception;

    public int Update() throws Exception;

    public int Delete() throws Exception;

    public void TableData(JoTable table) throws Exception;

    public void Combobox(JoCombobox combobox) throws Exception;

}
