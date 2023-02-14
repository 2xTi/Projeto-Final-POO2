package Classes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {
    private static List<Filme> filmeTestando;
    static Filme f1;

    @BeforeAll
    public static void setup(){
        System.out.println("Instanciando o filme");
        f1 = new Filme(
                "Teste do filme",
                "Testando",
                "Diego Henrique",
                "UFU",
                "abc",
                12,
                "18",
                150);
    }

    @AfterAll
    public static void teardown(){
        System.out.println("Testes finalizados");
        f1 = new Filme(
                null,
                null,
                null,
                null,
                null,
                0,
                null,
                0);
    }

    @AfterEach
    public void mensagemEntreTestes(){System.out.println("Teste encerrado, iniciando o próximo!");}

    @Test
    public void testarNomeNotNull(){
        assertNotNull(f1.getNomeFilme(), "Assert NotNull Falhou");
    }

    @Test
    public void testarSinopseNotNull(){
        assertNotNull(f1.getSinopse(), "Assert NotNull Falhou");
    }

    @Test
    public void testarDiretorNotNull(){assertNotNull(f1.getDiretor(), "Assert NotNull Falhou");}

    @Test
    public void testarProdutoraNotNull(){assertNotNull(f1.getProdutora(), "Assert NotNull Falhou");}

    @Test
    public void testarCodigoNotNull(){assertNotNull(f1.getCodigo(), "Assert NotNull Falhou");}

    @Test
    public void testarValorIngressoNotNull(){assertNotNull(f1.getValorIngresso(), "Assert NotNull Falhou");}

    @Test
    public void verValorIngressoPositivo(){assertTrue(f1.getValorIngresso() >= 0 , "Assert True Falhou");}

    @Test
    public void verificarNomeCompletoDiretor(){assertTrue(f1.getDiretor().contains(" "), "Assert True falhou");}

    @Test
    public void testarIdadeNotNull(){assertNotNull(f1.getIdade(), "Assert NotNull Falhou");}

    @Test
    public void testarFilmeMaiorDeIdade(){assertEquals("18", f1.getIdade(), "Assert Equals Falhou");}

    @Test
    public void testarValorMaximoExcedido(){assertTrue(f1.getValorIngresso() <= 999.99);}

    @Test
    public void valorIngressoVerificar(){assertTrue(f1.getValorIngresso() > 0.0, "Assert True Falhou");}

    @Test
    public void testarQtdIngressoValida(){assertTrue(f1.getQntdIngressos() > 0, "Assert True Falhou");}

    @Test
    public void testarSeOsIngressosEstaoEsgotados(){assertNotEquals(0,f1.getQntdIngressos(), "Assert Equals Falhou");}

    @Test
    public void testarQtdIngressoNotNull(){assertNotNull(f1.getQntdIngressos(), "Assert NotNull Falhou");}
}