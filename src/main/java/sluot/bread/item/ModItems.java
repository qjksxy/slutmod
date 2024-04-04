package sluot.bread.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import sluot.bread.SLUoTMod;
import sluot.bread.item.toolitem.HuMoZhiZhang;
import sluot.bread.sounds.ModSounds;


/**
 * 在此类中定义所有的物品（Items）<br>
 * 添加物品步骤：<br><b>注意：避免 name 以及相关文件名大写</b><br>
 * 1. 在本类中创建物品对应的 public static final Item 对象<br>
 * 2. 在类 SLUTModItemGroup 中，将物品添加到合适的物品组<br>
 * 3. 在 resources/.../lang/ 下的 json 文件中，添加物品的游戏内名称<br>
 * 4. 在 resources/.../models/item/ 中，创建说明文件<br>
 * 5. 在 resources/.../textures/item/ 中，创建材质图片
 */
public class ModItems {
    // 黄水晶 测试用
    public static final Item CITRINE = registerItem("item_citrine",
            new Item(new FabricItemSettings()));
    // SLUT 徽章
    public static final Item SLUT = registerItem("item_sluot",
            new Item(new FabricItemSettings()));

    public static final Item SIWANGZHIWU = registerItem("item_siwangzhiwu",
            new SwordItem(ToolMaterials.IRON, 3, -2.4f, new FabricItemSettings()));

    public static final Item JINGSHUILIUYONG = registerItem("item_jingshuiliuyong",
            new SwordItem(ToolMaterials.IRON, 3, -2.4f, new FabricItemSettings()));

    public static final Item HUMOZHIZHANG = registerItem("item_humozhizhang",
            new HuMoZhiZhang(ToolMaterials.IRON, 3, -2.4f, new FabricItemSettings()));

    // 唱片
    public static final Item AOMO_MUSIC_DISC = registerItem("item_music_disc_aomo",
            new MusicDiscItem(7, ModSounds.AOMO, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 161));
    public static final Item WHITE_NIGHT_MUSIC_DISC = registerItem("item_music_disc_white_night",
            new MusicDiscItem(7, ModSounds.WHITE_NIGHT, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 138));
    public static final Item LAMENTATION_MUSIC_DISC = registerItem("item_music_disc_lamentation",
            new MusicDiscItem(7, ModSounds.LAMENTATION, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 229));
    public static final Item NEVER_ENDING_MUSIC_DISC = registerItem("item_music_disc_never_ending",
            new MusicDiscItem(7, ModSounds.NEVER_ENDING, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 171));
    public static final Item RONDEAU_DES_MUSIC_DISC = registerItem("item_music_disc_rondeau_des",
            new MusicDiscItem(7, ModSounds.RONDEAU_DES, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 233));

    // 僵尸系列卡牌
    public static final Item ZOM_1 = registerItem("item_zom_1",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_2 = registerItem("item_zom_2",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_3 = registerItem("item_zom_3",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_4 = registerItem("item_zom_4",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_5 = registerItem("item_zom_5",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_6 = registerItem("item_zom_6",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_7 = registerItem("item_zom_7",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_8 = registerItem("item_zom_8",
            new Item(new FabricItemSettings()));
    public static final Item ZOM_9 = registerItem("item_zom_9",
            new Item(new FabricItemSettings()));

    /*
     ***** 下列方法的用途和实现无需关心 *****
     */
    public static void registerClass() {
        SLUoTMod.LOGGER.debug(SLUoTMod.MOD_ID + "-Registering class: " + ModItems.class.getName());
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM,
                new Identifier(SLUoTMod.MOD_ID, name), item);
    }
}