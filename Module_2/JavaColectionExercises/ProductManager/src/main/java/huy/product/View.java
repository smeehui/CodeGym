package huy.product;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWord;
import de.vandermeer.asciitable.CWC_LongestWordMin;
import de.vandermeer.asciithemes.TA_GridThemes;
import de.vandermeer.asciithemes.a8.A8_Grids;
import de.vandermeer.asciithemes.u8.U8_Grids;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.HashMap;

import static huy.product.Handler.sc;

public class View {

    public View() {
    }

    public void menu(String ... title) {
        HashMap<Integer,String> menu = new HashMap<>();
        for (int i = 1; i < title.length;i++){
            menu.put(i, title[i]);
        }
        AsciiTable table = new AsciiTable();
        table.addHeavyRule();
        AT_Row row =  table.addRow(null,title[0]);
        row.setTextAlignment(TextAlignment.CENTER);
        table.getRenderer().setCWC(new CWC_LongestWordMin(new int[]{5,100}));
        table.addHeavyRule();
        for (int i = 0; i <menu.size(); i++){
            AT_Row dataRow = table.addRow(i+1,menu.get(i+1));
            dataRow.getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
        }
        table.addRule();
        table.addRow("#", "Return").getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
        table.addRule();
        table.getContext().setGridTheme(TA_GridThemes.HORIZONTAL);
        table.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.println(table.render());
    }
    public void sortSubMenus(String type) {
        menu(type,"Ascending", "Descending");
    }

    public void sortByPriceMenu() {
        System.out.println("""
                Sort by price:
                1. Ascending order
                2. Descending order
                """);
    }

    public String show(ArrayList<Product> list) {
        AsciiTable at = new AsciiTable();
//        at.addHeavyRule();
        at.addRule();
        AT_Row tHead = at.addRow("#", "ID", "NAME", "QUANTITY", "PRICE", "DESCRIPTION","ADDED DATE");
        tHead.getCells().get(1).getContext().setTextAlignment(TextAlignment.RIGHT);
        tHead.getCells().get(2).getContext().setTextAlignment(TextAlignment.RIGHT);
        tHead.getCells().get(3).getContext().setTextAlignment(TextAlignment.RIGHT);
        at.getRenderer().setCWC(new CWC_LongestWordMin(new int[]{3,4,20,10,20,50,20}));
        at.setTextAlignment(TextAlignment.CENTER);
//        at.addHeavyRule();
        at.addRule();
        int count = 0;
        for (Product product : list) {
            String price= String.format("%,.0f",  product.getPrice());
            AT_Row row = at.addRow(++count, product.getID(), product.getName(), product.getAmount(),price, product.getDescription(),product.getDateAdded());
            row.getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
            row.getCells().get(1).getContext().setTextAlignment(TextAlignment.RIGHT);
            row.getCells().get(3).getContext().setTextAlignment(TextAlignment.RIGHT);
            row.getCells().get(4).getContext().setTextAlignment(TextAlignment.RIGHT);
            at.addRule();
        }
        at.getContext().setGrid(U8_Grids.borderDoubleLight());
        System.out.println(at.render(100));
        return at.render(100);
    }
    public void pagination(ArrayList<Product> list,int elementPerPage) {
        int page=(int) Math.ceil(list.size()/elementPerPage);
        int full = list.size()%elementPerPage;
        for (int i = 0; i <= page; i++) {
            if (i==page) show(new ArrayList<>(list.subList(i*elementPerPage, full==0?(i+1)*elementPerPage:i*elementPerPage+full)));
            else show(new ArrayList<>(list.subList(i*elementPerPage,(i+1)*elementPerPage)));
            System.out.println("Showing page " + (i+1)+ " of "+ (page+1));
            sc.nextLine();
        }
    }
    public void subMenu(String title){
        AsciiTable table = new AsciiTable();
        table.addHeavyRule();
        table.addRow(title.toUpperCase()).getCells().get(0).getContext().setTextAlignment(TextAlignment.CENTER);
        table.addHeavyRule();
        table.getContext().setGrid(A8_Grids.lineDoubleBlocks());
        System.out.println(table.render(100));
    }

}
