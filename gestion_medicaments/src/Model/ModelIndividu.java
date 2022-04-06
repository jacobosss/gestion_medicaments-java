/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.TypeIndividu;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jacob
 */
public class ModelIndividu extends AbstractTableModel 
{
    private String[] nomsColonnes = {"Code", "Libellé"};
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
    
    public void loadDatas(ArrayList<TypeIndividu> lesIndividus)
    {
        rows = new Vector<>();
        for(TypeIndividu ind : lesIndividus)
        {
            rows.add(new String[]{String.valueOf(ind.getIdIndividu()),ind.getLibelleIndividu()});
        }
        fireTableChanged(null);
    }
    
}