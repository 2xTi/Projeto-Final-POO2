package Classes;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private static ArrayList<User> userTestando;
    static User u1;

    @BeforeAll
    public static void setup(){
        System.out.println("Instanciando o usuario");
        u1 = new User(
                "12345678910",
                "Diego Onfs",
                "123");
    }

    @AfterAll
    public static void teardown(){
        System.out.println("Testes finalizados");
        u1 = new User(
                null,
                null,
                null);
    }
    @AfterEach
    public void mensagemEntreTestes(){System.out.println("Teste encerrado, iniciando o próximo!");}

    @Test
    public void testarCpfNotNull(){assertNotNull(u1.getCpf(), "Assert NotNull Falhou");}

    @Test
    public void testarNomeNotNull(){assertNotNull(u1.getNomeCompleto(), "Assert NotNull Falhou");}

    @Test
    public void testarSenhaNotNull(){assertNotNull(u1.getSenha(), "Assert NotNull Falhou");}

    @Test
    public void testarTamanhoValidoCpf(){assertEquals(11, u1.getCpf().length(), "Assert Equals Falhou");}

    @Test
    public void testarNomeTamanho(){assertTrue(u1.getNomeCompleto().length() > 0, "Assert True Falhou");}

    @Test
    public void invalidarSenhaIgualACpf(){assertNotEquals(u1.getCpf(), u1.getSenha(), "Assert NotEquals Falhou");}

    @Test
    public void invalidarSenhaIgualANome(){assertNotEquals(u1.getNomeCompleto(), u1.getSenha(), "Assert NotEquals Falhou");}

    @Test
    public void verificarSeASenhaExedeUmValor(){assertTrue(u1.getSenha().length() < 30);}

    @Test
    public void verificarEspacoNomeCompleto(){assertTrue(u1.getNomeCompleto().contains(" "), "Assert True Falhou");}

    @Test
    public void verificarEspacoNoCPF(){assertFalse(u1.getCpf().contains(" "));}
}