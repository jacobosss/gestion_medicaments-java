/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.TypeIndividu;
import Entity.Medicament;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jacob
 */
public class ModelMedicament extends AbstractTableModel{
    
    private String[] nomsColonnes = {"Libellé"};
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
    
    public void loadDatas(ArrayList<Medicament> lesMedicaments)
    {
        rows = new Vector<>();
        for(Medicament med : lesMedicaments)
        {
            rows.add(new String[]{String.valueOf(med.getMed_nomcommercial())});
        }
        fireTableChanged(null);
    }
    
    public void loadDatas8Colonnes(ArrayList<Medicament> lesMedicaments)
{
 rows = new Vector<>();
 nomsColonnes = new String[]{ "Dépôt Légal","Nom" ,"Famille","Composition","Effets","Contre-indications","Prix"};
 for (Medicament m : lesMedicaments)
 {
 rows.add(new String[]{String.valueOf(m.getMed_depotlegal()),String.valueOf(m.getMed_nomcommercial()),String.valueOf(m.getFam_code()),m.getMed_composition(),m.getMed_effets(),m.getMed_contreindic(),String.valueOf(m.getMed_prixechantillon())});
 }
fireTableChanged(null);
}

public void loadDatas2Colonnes(ArrayList<Medicament> lesMedicaments)
{
rows = new Vector<>();
nomsColonnes = new String[]{"Dépôt légal", "Nom"};
for (Medicament m : lesMedicaments)
{
rows.add(new String[]{String.valueOf(m.getMed_depotlegal()),m.getMed_nomcommercial()});
}
fireTableChanged(null);
}
    
    
}
