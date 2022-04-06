/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Dosages;
import Entity.TypeIndividu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Jacob
 */
public class ModelDosages extends AbstractTableModel
{
    private String[] nomsColonnes = {"Quantité", "Unité"};
    private Vector<String[]> rows;

    @Override
    public int getRowCount() 
    {
        return rows.size();
    }

    @Override
    public int getColumnCount() 
    {
        return nomsColonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        return rows.get(rowIndex)[columnIndex];
    }
    
    @Override
    public String getColumnName(int column) {
        return nomsColonnes[column]; 
    }
    
    public void loadDatas(ArrayList<Dosages> lesDosages)
    {
        rows = new Vector<>();
        for(Dosages dos : lesDosages)
        {
            rows.add(new String[]{dos.getDosage_quantite(),dos.getDosage_unite()});
        }
        fireTableChanged(null);
    }
    
}
