package dev.emi.emi.recipe;

import dev.emi.emi.api.recipe.*;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EmiComposterRecipe extends EmiIngredientRecipe {
    private final List<EmiStack> stacks;
    public final float chance;
    private final EmiIngredient ingredient;
    public EmiComposterRecipe(float chance, List<EmiStack> stacks) {
        this.stacks = stacks;
        this.chance = chance;
        this.ingredient = EmiStack.of(Blocks.COMPOSTER).setChance(chance);
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return VanillaEmiRecipeCategories.COMPOSTING;
    }

    @Override
    public @Nullable Identifier getId() {
        return null;
    }

    @Override
    protected EmiIngredient getIngredient() {
        return ingredient;
    }

    @Override
    protected List<EmiStack> getStacks() {
        return stacks;
    }

    @Override
    protected EmiRecipe getRecipeContext(EmiStack stack, int offset) {
        return new EmiResolutionRecipe(ingredient, stack);
    }
}
