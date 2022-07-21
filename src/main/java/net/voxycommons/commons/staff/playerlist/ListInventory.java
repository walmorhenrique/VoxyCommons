package net.voxycommons.commons.staff.playerlist;

import com.henryfabio.minecraft.inventoryapi.editor.InventoryEditor;
import com.henryfabio.minecraft.inventoryapi.inventory.impl.paged.PagedInventory;
import com.henryfabio.minecraft.inventoryapi.item.InventoryItem;
import com.henryfabio.minecraft.inventoryapi.item.enums.DefaultItem;
import com.henryfabio.minecraft.inventoryapi.item.supplier.InventoryItemSupplier;
import com.henryfabio.minecraft.inventoryapi.viewer.Viewer;
import com.henryfabio.minecraft.inventoryapi.viewer.configuration.impl.ViewerConfigurationImpl;
import com.henryfabio.minecraft.inventoryapi.viewer.impl.paged.PagedViewer;
import net.voxycommons.utils.ItemBuilder;
import net.voxycommons.utils.SkullBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static net.voxycommons.utils.YmlConfigurator.MStaff;

public class ListInventory extends PagedInventory {

    public ListInventory() {
        super(
                "list.inventory.paged.players.all", // Identificador do inventário (deve ser único)
                MStaff.getString("Menus.Menu_PlayerList.nome"), // Título padrão do inventário
                9 * 6 // Tamanho do inventário
        );
    }

    @Override
    protected void configureViewer(PagedViewer viewer) {
        ViewerConfigurationImpl.Paged configuration = viewer.getConfiguration();
        configuration.previousPageSlot(45);
        configuration.nextPageSlot(53);
        configuration.itemPageLimit(1);
    }

    @Override
    protected void configureInventory(Viewer viewer, InventoryEditor editor) {
        InventoryItem back = DefaultItem.PREVIOUS_PAGE.toInventoryItem(viewer);
        ItemStack backStack = back.getItemStack();
        ItemMeta meta = backStack.getItemMeta();
        meta.setDisplayName(MStaff.getString("Menus.Menu_PlayerList.itens.voltar pagina.nome"));
        meta.setLore(MStaff.getStringList("Menus.Menu_PlayerList.itens.voltar pagina.lore").stream().map(lore -> lore.replace("&", "§")).collect(Collectors.toList()));
        backStack.setItemMeta(meta);

        InventoryItem next = DefaultItem.NEXT_PAGE.toInventoryItem(viewer);
        ItemStack nextItemStack = next.getItemStack();
        ItemMeta meta2 = nextItemStack.getItemMeta();
        meta2.setDisplayName(MStaff.getString("Menus.Menu_PlayerList.itens.proxima pagina.nome"));
        meta2.setLore(MStaff.getStringList("Menus.Menu_PlayerList.itens.proxima pagina.lore").stream().map(lore -> lore.replace("&", "§")).collect(Collectors.toList()));
        nextItemStack.setItemMeta(meta2);

        ItemStack voltar = new ItemBuilder(Material.getMaterial(MStaff.getString("Menus.Menu_PlayerList.itens.voltar-menu.material")),
        1, (short) MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.data"))
        .setName(MStaff.getString("Menus.Menu_PlayerList.itens.voltar-menu.nome").replace("&", "§"))
        .setLore(MStaff.getStringList("Menus.Menu_PlayerList.itens.voltar-menu.lore").stream().map(lore -> lore.replace("&", "§")).collect(Collectors.toList())).build();
        editor.setItem(MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.slot"), InventoryItem.of(voltar));

    }

    @Override
    protected List<InventoryItemSupplier> createPageItems(PagedViewer viewer) {
        List<InventoryItemSupplier> itemSuppliers = new LinkedList<>();

        // SETANDO A CABEÇA DE CADA PLAYER ONLINE NO INVENTÁRIO
        for(Player player : Bukkit.getOnlinePlayers()) {
            ItemStack skull = new SkullBuilder(player.getName(), false)
                    .setDisplayName(MStaff.getString("Menus.Menu_PlayerList.itens.format.nome").replace("&", "§").replace("{jogador}", player.getName()))
                    .setLore(MStaff.getStringList("Menus.Menu_PlayerList.itens.format.lore").stream().map(lore -> lore.replace("&", "§")).collect(Collectors.toList()))
                    .build();

            itemSuppliers.add(() -> InventoryItem.of(skull));
        }

        return itemSuppliers;
    }
}