package com.pi4.ecommerce.SmokeNSmokeV2.controller;

import com.pi4.ecommerce.SmokeNSmokeV2.dao.ImagemProdutoDAO;
import com.pi4.ecommerce.SmokeNSmokeV2.dao.ProdutoDAO;
import com.pi4.ecommerce.SmokeNSmokeV2.models.ImagemProduto;
import com.pi4.ecommerce.SmokeNSmokeV2.models.Produto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BackofficeProdutoController {

    @GetMapping("/produtos")
    public ModelAndView mostrarTela() {

        ModelAndView mv = new ModelAndView("listaProdutos");
        ProdutoDAO produtoDao = new ProdutoDAO();
        List<Produto> produtos = produtoDao.getProdutos();
        mv.addObject("listarProdutos", produtos);
        return mv;
    }

    @GetMapping("/cadastrarProduto")
    public ModelAndView exibirCadastro() {
        Produto p = new Produto();

        ModelAndView mv = new ModelAndView("cadastroProduto");
        mv.addObject("produto", p);

        return mv;
    }

    @GetMapping("/alterarProduto/{id_produto}")
    public ModelAndView exibirAlterarProduto(@PathVariable("id_produto") int id_produto) {

        ModelAndView mv = new ModelAndView("alterarProduto");
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto p = produtoDao.getProdutos(id_produto);

        ImagemProdutoDAO imagensProdutoDAO = new ImagemProdutoDAO();
        List<ImagemProduto> listaImagens = imagensProdutoDAO.getImagensProduto(id_produto);

        mv.addObject("produto", p);
        mv.addObject("listaImagens", listaImagens);

        return mv;
    }

    @GetMapping("/detalheProduto/{id_produto}")
    public ModelAndView verProduto(@PathVariable("id_produto") int id_produto) {

        ModelAndView mv = new ModelAndView("detalheProduto");
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto p = produtoDao.getProdutos(id_produto);

        ImagemProdutoDAO imagensProdutoDAO = new ImagemProdutoDAO();
        List<ImagemProduto> listaImagens = imagensProdutoDAO.getImagensProduto(id_produto);

        mv.addObject("produto", p);
        mv.addObject("listaImagens", listaImagens);

        return mv;
    }

    @PutMapping("/alterarProduto/{id_produto}")
    public ModelAndView alterarProduto(
            @PathVariable("id_produto") int id_produto,
            @ModelAttribute(value = "produto") Produto p,
            @RequestParam(value = "imagem", required = false) String[] imagens) {

        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.alterarProduto(p);

        ImagemProdutoDAO imagemProdutoDao = new ImagemProdutoDAO();
        imagemProdutoDao.deletarImagensProduto(p.getId());

        if (imagens != null) {
            imagemProdutoDao.salvarImagensProduto(p.getId(), imagens);
        }

        ModelAndView mv = new ModelAndView("redirect:/produtos");

        return mv;
    }

    @PostMapping("/cadastrarProduto")
    public ModelAndView adicionarProduto(
            @ModelAttribute(value = "produto") Produto p,
            @RequestParam(value = "imagem", required = false) String[] imagens) {

        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.salvarProduto(p);

        int produto_id = produtoDao.getUltimoProduto();

        ImagemProdutoDAO imagemProdutoDao = new ImagemProdutoDAO();

        if (imagens != null) {
            imagemProdutoDao.salvarImagensProduto(produto_id, imagens);
        }

        ModelAndView mv = new ModelAndView("redirect:/produtos");

        return mv;
    }

}
