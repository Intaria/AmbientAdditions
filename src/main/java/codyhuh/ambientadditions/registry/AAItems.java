package codyhuh.ambientadditions.registry;

import codyhuh.ambientadditions.AmbientAdditions;
import codyhuh.ambientadditions.common.items.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class AAItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AmbientAdditions.MOD_ID);
    public static final CreativeModeTab TAB = new CreativeModeTab(AmbientAdditions.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return STAG_BEETLE_BOTTLE.get().getDefaultInstance();
        }
    };

    // Buckets & Catching Items
    public static final RegistryObject<Item> LONGHORN_COWFISH_BUCKET = ITEMS.register("longhorn_cowfish_bucket", () -> new MobBucketItem(AAEntities.LONGHORN_COWFISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> HARLEQUIN_SHRIMP_BUCKET = ITEMS.register("harlequin_shrimp_bucket", () -> new MobBucketItem(AAEntities.HARLEQUIN_SHRIMP, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> CHOCOLATE_CHIP_STARFISH_BUCKET = ITEMS.register("chocolate_chip_starfish_bucket", () -> new MobBucketItem(AAEntities.CHOCOLATE_CHIP_STARFISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    //public static final RegistryObject<Item> FLYING_FISH_BUCKET = ITEMS.register("flying_fish_bucket", () -> new MobBucketItem(AAEntities.FLYING_FISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB)/**/.stacksTo(1)));
    public static final RegistryObject<Item> SHAME_FACED_CRAB_BUCKET = ITEMS.register("shame_faced_crab_bucket", () -> new MobBucketItem(AAEntities.SHAME_FACED_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> MOLE_BUCKET = ITEMS.register("mole_bucket", () -> new AACatchableItem(AAEntities.MOLE::get, Items.BUCKET, true, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> PINOCCHIO_ANOLE_POT = ITEMS.register("pinocchio_anole_pot", () -> new AACatchableItem(AAEntities.PINOCCHIO_ANOLE::get, Items.FLOWER_POT, false, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> LEAF_FROG_BOWL = ITEMS.register("leaf_frog_bowl", () -> new AACatchableItem(AAEntities.LEAF_FROG::get, Items.BOWL, false, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> STAG_BEETLE_BOTTLE = ITEMS.register("stag_beetle_bottle", () -> new AACatchableItem(AAEntities.STAG_BEETLE::get, Items.GLASS_BOTTLE, false, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> NAPOLEON_WRASSE_BUCKET = ITEMS.register("napoleon_wrasse_bucket", () -> new MobBucketItem(AAEntities.NAPOLEON_WRASSE, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> BLUE_SPOTTED_STINGRAY_BUCKET = ITEMS.register("blue_spotted_stingray_bucket", () -> new MobBucketItem(AAEntities.BLUE_SPOTTED_STINGRAY, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().tab(TAB).stacksTo(1)));
    public static final RegistryObject<Item> GIANT_LAND_SNAIL_POT = ITEMS.register("giant_land_snail_pot", () -> new AACatchableItem(AAEntities.GIANT_LAND_SNAIL::get, Items.FLOWER_POT, false, new Item.Properties().tab(TAB).stacksTo(1)));
    
    // Drops & Materials
    public static final RegistryObject<Item> STARFISH_ARM = ITEMS.register("starfish_arm", () -> new StarfishArmItem(new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> LONGHORN_COWFISH = ITEMS.register("longhorn_cowfish", () -> new Item(new Item.Properties().tab(TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    //public static final RegistryObject<Item> FLYING_FISH = ITEMS.register("flying_fish", () -> new Item(new Item.Properties().tab(TAB)/**/.food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build())));
    
    // Gear
    public static final RegistryObject<Item> DUCKY_MASK = ITEMS.register("ducky_mask", () -> new DuckyMaskItem(EquipmentSlot.HEAD));
    
    // Spawn Eggs
    public static final RegistryObject<Item> WHITE_FRUIT_BAT_SPAWN_EGG = ITEMS.register("white_fruit_bat_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.WHITE_FRUIT_BAT, 0xf9f5e5, 0xffd000, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> LONGHORN_COWFISH_SPAWN_EGG = ITEMS.register("longhorn_cowfish_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.LONGHORN_COWFISH, 0xfcf267, 0x5ddbfe, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> STAG_BEETLE_SPAWN_EGG = ITEMS.register("stag_beetle_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.STAG_BEETLE, 0x412320, 0xa67124, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> NINE_BANDED_ARMADILLO_SPAWN_EGG = ITEMS.register("nine_banded_armadillo_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.NINE_BANDED_ARMADILLO, 0x433634, 0xa08073, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> VEILED_CHAMELEON_SPAWN_EGG = ITEMS.register("veiled_chameleon_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.VEILED_CHAMELEON, 0x1ccf3d, 0xfffa45, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> MOLE_SPAWN_EGG = ITEMS.register("mole_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.MOLE, 0x493f3d, 0xffa8a5, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> PEMBROKE_CORGI_SPAWN_EGG = ITEMS.register("pembroke_corgi_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.PEMBROKE_CORGI, 0xd57832, 0xdfbf97, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> CARDIGAN_CORGI_SPAWN_EGG = ITEMS.register("cardigan_corgi_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.CARDIGAN_CORGI, 0x312a23, 0xf1debd, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> NAPOLEON_WRASSE_SPAWN_EGG = ITEMS.register("napoleon_wrasse_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.NAPOLEON_WRASSE, 0xbcdb51, 0x04658e, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> IIWI_SPAWN_EGG = ITEMS.register("iiwi_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.IIWI, 0xb10f1b, 0x212833, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> PINOCCHIO_ANOLE_SPAWN_EGG = ITEMS.register("pinocchio_anole_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.PINOCCHIO_ANOLE, 0x898734, 0xd0a850, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> AYE_AYE_SPAWN_EGG = ITEMS.register("aye_aye_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.AYE_AYE, 0x403832, 0xc4c2a9, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> RING_TAILED_LEMUR_SPAWN_EGG = ITEMS.register("ring_tailed_lemur_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.RING_TAILED_LEMUR, 0x544e4a, 0xcac5bc, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> SIAMANG_GIBBON_SPAWN_EGG = ITEMS.register("siamang_gibbon_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.SIAMANG_GIBBON, 0x2c2a2a, 0x171212, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> MARTEN_SPAWN_EGG = ITEMS.register("marten_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.MARTEN, 0x321612, 0xa38a60, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> GIANT_LAND_SNAIL_SPAWN_EGG = ITEMS.register("giant_land_snail_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.GIANT_LAND_SNAIL, 0x7c5e49, 0xc4b78d, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> CHOCOLATE_CHIP_STARFISH_SPAWN_EGG = ITEMS.register("chocolate_chip_starfish_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.CHOCOLATE_CHIP_STARFISH, 0xd0c7ad, 0x564f42, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> HARLEQUIN_SHRIMP_SPAWN_EGG = ITEMS.register("harlequin_shrimp_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.HARLEQUIN_SHRIMP, 0xe1e1f9, 0x667ce6, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> LEAF_FROG_SPAWN_EGG = ITEMS.register("leaf_frog_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.LEAF_FROG, 0x783e29, 0x44241a, new Item.Properties().tab(TAB)));
    //public static final RegistryObject<Item> FLYING_FISH_SPAWN_EGG = REGISTER.register("flying_fish_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.FLYING_FISH, 0x6e86a8, 0xaec2d4, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> SHAME_FACED_CRAB_SPAWN_EGG = ITEMS.register("shame_faced_crab_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.SHAME_FACED_CRAB, 0xc7ab90, 0xb3654a, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> OPAH_SPAWN_EGG = ITEMS.register("opah_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.OPAH, 0x3abbc7, 0xe3f0f1, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BLUNTHEAD_TREE_SNAKE_SPAWN_EGG = ITEMS.register("blunthead_tree_snake_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.BLUNTHEAD_TREE_SNAKE, 0xe9e1cf, 0x975730, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BLUE_SPOTTED_STINGRAY_SPAWN_EGG = ITEMS.register("blue_spotted_stingray_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.BLUE_SPOTTED_STINGRAY, 0xe4e67e, 0x1b8cca, new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> SLOTH_BEAR_SPAWN_EGG = ITEMS.register("sloth_bear_spawn_egg", () -> new ForgeSpawnEggItem(AAEntities.SLOTH_BEAR, 0x324242, 0xc8cbb2, new Item.Properties().tab(TAB)));

    // BlockItems
    public static final RegistryObject<Item> LEAF_FROGSPAWN = ITEMS.register("leaf_frogspawn", () -> new PlaceOnWaterBlockItem(AABlocks.LEAF_FROGSPAWN.get(), new Item.Properties().tab(TAB)));

}