package br.com.Avaliacao.principal;

import br.com.Avaliacao.controller.ProdutoController;
import br.com.Avaliacao.dao.ProdutoDao;
import br.com.Avaliacao.view.ProdutoView;

public class Main {
    public static void main( String[] args ) {
    	ProdutoDao dao = new ProdutoDao();
    	ProdutoController controller = new ProdutoController(dao);
    	ProdutoView view = new ProdutoView(controller);
    	view.exibirMenu();
    	
        
    }
}
