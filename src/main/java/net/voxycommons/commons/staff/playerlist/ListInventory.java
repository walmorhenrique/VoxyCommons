package net.voxycommons.commons.staff.playerlist;

import com.henryfabio.minecraft.inventoryapi.inventory.impl.paged.*;
import com.henryfabio.minecraft.inventoryapi.viewer.impl.paged.*;
import com.henryfabio.minecraft.inventoryapi.viewer.configuration.impl.*;
import com.henryfabio.minecraft.inventoryapi.viewer.*;
import com.henryfabio.minecraft.inventoryapi.editor.*;
import com.henryfabio.minecraft.inventoryapi.item.enums.*;
import java.util.stream.*;
import com.henryfabio.minecraft.inventoryapi.item.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import com.henryfabio.minecraft.inventoryapi.item.supplier.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import net.voxycommons.utils.*;
import java.util.*;

public class ListInventory extends PagedInventory {

    public ListInventory() {
        super("list.inventory.paged.players.all", YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.nome"), 54);
    }
    
    @Override
    protected void configureViewer(final PagedViewer viewer) {
        final ViewerConfigurationImpl.Paged configuration = viewer.getConfiguration();
        configuration.previousPageSlot(45);
        configuration.nextPageSlot(53);
        configuration.itemPageLimit(21);
    }
    
    @Override
    protected void configureInventory(Viewer viewer, InventoryEditor editor) {
        InventoryItem back = DefaultItem.PREVIOUS_PAGE.toInventoryItem(viewer);
        ItemStack backStack = back.getItemStack();
        ItemMeta meta = backStack.getItemMeta();
        meta.setDisplayName(YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.itens.voltar pagina.nome"));
        meta.setLore(YmlConfigurator.MStaff.getStringList("Menus.Menu_PlayerList.itens.voltar pagina.lore").stream().map(lore -> lore.replace("&", "�")).collect(Collectors.toList()));
        backStack.setItemMeta(meta);
        InventoryItem next = DefaultItem.NEXT_PAGE.toInventoryItem(viewer);
        ItemStack nextItemStack = next.getItemStack();
        ItemMeta meta2 = nextItemStack.getItemMeta();
        meta2.setDisplayName(YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.itens.proxima pagina.nome"));
        meta2.setLore(YmlConfigurator.MStaff.getStringList("Menus.Menu_PlayerList.itens.proxima pagina.lore").stream().map(lore -> lore.replace("&", "�")).collect(Collectors.toList()));
        nextItemStack.setItemMeta(meta2);
        ItemStack voltar = new ItemBuilder(Material.getMaterial(YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.itens.voltar-menu.material")), 1, (short)YmlConfigurator.MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.data")).setName(YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.itens.voltar-menu.nome").replace("&", "�")).setLore((List<String>)YmlConfigurator.MStaff.getStringList("Menus.Menu_PlayerList.itens.voltar-menu.lore").stream().map(lore -> lore.replace("&", "�")).collect(Collectors.toList())).build();
        editor.setItem(YmlConfigurator.MStaff.getInt("Menus.Menu_PlayerList.itens.voltar-menu.slot"), InventoryItem.of(voltar));
    }
    
    @Override
    protected List<InventoryItemSupplier> createPageItems(PagedViewer viewer) {
        List<InventoryItemSupplier> itemSuppliers = new LinkedList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            ItemStack skull = new SkullBuilder(player.getName(), false).setDisplayName(YmlConfigurator.MStaff.getString("Menus.Menu_PlayerList.itens.format.nome").replace("&", "�").replace("{jogador}", player.getName())).setLore((List<String>)YmlConfigurator.MStaff.getStringList("Menus.Menu_PlayerList.itens.format.lore").stream().map(lore -> lore.replace("&", "�")).collect(Collectors.toList())).build();
            itemSuppliers.add(() -> InventoryItem.of(skull));
        }
        return itemSuppliers;
    }
}
