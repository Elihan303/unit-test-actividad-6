import org.junit.Test;
import static org.junit.Assert.*;

//Caso de Prueba 2: Actualizar Información de un Producto Existente
public class TestActualizarProductoExistente {

    @Test
    public void testActualizarProductoExitoso() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        Usuario usuario = new Usuario("usuario1", "contraseña");
        sistema.agregarProducto(usuario, "Producto Existente", "Descripción", "Categoría", 5.99, 50);

        // Acción
        boolean resultado = sistema.actualizarProducto(usuario, "Producto Existente", "Nueva Descripción", "Nueva Categoría", 7.99, 100);

        // Verificación
        assertTrue(resultado);
        Producto productoActualizado = sistema.obtenerProducto("Producto Existente");
        assertEquals("Nueva Descripción", productoActualizado.getDescripcion());
        assertEquals("Nueva Categoría", productoActualizado.getCategoria());
        assertEquals(7.99, productoActualizado.getPrecio(), 0);
        assertEquals(100, productoActualizado.getCantidad());
    }

    @Test
    public void testActualizarProductoNoExistente() {
        // Preparación
        SistemaGestionInventario sistema = new SistemaGestionInventario();
        Usuario usuario = new Usuario("usuario1", "contraseña");

        // Acción
        boolean resultado = sistema.actualizarProducto(usuario, "Producto No Existente", "Nueva Descripción", "Nueva Categoría", 7.99, 100);

        // Verificación
        assertFalse(resultado);
    }
}