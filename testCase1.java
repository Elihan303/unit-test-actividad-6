import org.junit.Test;
import static org.junit.Assert.*;


//Caso de Prueba 1: Agregar Nuevo Producto al Inventario
public class TestAgregarNuevoProducto {

    @Test
    public void testAgregarNuevoProductoExitoso() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        Usuario usuario = new Usuario("usuario1", "contraseña");

        // Acción
        boolean resultado = sistema.agregarProducto(usuario, "Nuevo Producto", "Descripción del Nuevo Producto", "Categoría", 10.50, 100);

        // Verificación
        assertTrue(resultado);
        assertTrue(sistema.existeProducto("Nuevo Producto"));
    }

    @Test
    public void testAgregarProductoExistente() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        Usuario usuario = new Usuario("usuario1", "contraseña");
        sistema.agregarProducto(usuario, "Existente", "Descripción", "Categoría", 5.99, 50);

        // Acción
        boolean resultado = sistema.agregarProducto(usuario, "Existente", "Descripción actualizada", "Categoría", 5.99, 50);

        // Verificación
        assertFalse(resultado);
        assertEquals("Descripción", sistema.obtenerProducto("Existente").getDescripcion()); // La descripción no debe cambiar
    }
}