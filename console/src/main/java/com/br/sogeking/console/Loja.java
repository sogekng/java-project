package com.br.sogeking.console;
import java.util.Scanner;
import java.util.ArrayList;

public class Loja {

    public static ArrayList<String> produto = new ArrayList<String>();

    public static void verProduto() {
        System.out.println("\nProdutos:\n");
        for (int i = 0; i < produto.size(); i++) {
            String[] split = produto.get(i).split(" - ");

            
            System.out.println((i+1) + "º" + " - " + split[0] + " - R$: " + split[1] + "Reais - " + split[2] + " unidades");
        }
    }

    public static void cadastrados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do produto: ");
        String nome = scanner.nextLine().toUpperCase();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();

        if(quantidade > 0){
            if(quantidade <= 1){
                System.out.print("\nProduto Cadastrado: " +nome + " - R$: " +preco + " Reais - " +quantidade + " unidade");
            }else{
                System.out.print("\nProduto Cadastrado: " +nome + " - R$: " +preco + " Reais - " +quantidade + " unidades");
            }
        } else {
            System.out.println("\nQuantidade inválida!");
        }
        
        if(nome != null && preco != 0 && quantidade != 0) {
            produto.add(nome + " - " +preco + " - " +quantidade);
        }else{
            System.out.println("\nProduto não cadastrado");
        }
    }

    public static void venderProduto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o nome do produto: ");
        String nome = scanner.nextLine().toUpperCase();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        
        try{
            for(int i=0; i<produto.size(); i++) {
                if(produto.get(i).contains(nome)) {
                    String[] split = produto.get(i).split(" - ");
                    int quantidadeAtual = Integer.parseInt(split[2]);
                    double preco = Double.parseDouble(split[1]);
                    if(quantidadeAtual >= quantidade) {
                        quantidadeAtual -= quantidade;
                        double preco_atual = preco * quantidade;
                        if (quantidade == 1){
                            System.out.println("\nProduto vendido: " +nome + " - R$: " +preco_atual + " Reais - " +quantidade + " unidade");
                        }
                        else{
                            System.out.println("\nProduto vendido: " +nome + " - R$: " +preco + " Reais - " +quantidade + " unidades");
                        }
                        produto.set(i, nome + " - " +preco + " - " +quantidadeAtual);
                    }else{
                        System.out.println("\nQuantidade insuficiente");
                    }
                }else{
                    System.out.println("\nProduto não encontrado");
                }
            }
        }catch(Exception e) {
            System.out.println("\nProduto não encontrado");
        }
    }
    
    public static void main(String[] args) {
        while(true){
            
            try{
                System.out.print("\n- 1 para cadastrar um produto\n- 2 para vender um produto\n- 3 ver produtos\n- 0 para sair\n: ");
                Scanner scanner = new Scanner(System.in);
                int opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        cadastrados();
                        break;
                    case 2:
                        venderProduto();
                        break;
                    case 3:
                        verProduto();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("\nOpção inválida");
                        break;
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
