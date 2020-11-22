package de.hglabor.blockshuffle.mixin;

import de.hglabor.blockshuffle.BlockShuffleMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.screen.world.WorldListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SelectWorldScreen.class)
public abstract class SelectWorldScreenMixin extends Screen {

    @Shadow protected TextFieldWidget searchBox;

    @Shadow private WorldListWidget levelList;

    @Shadow private ButtonWidget selectButton;

    @Shadow private ButtonWidget editButton;

    @Shadow private ButtonWidget deleteButton;

    @Shadow private ButtonWidget recreateButton;

    @Shadow @Final protected Screen parent;

    @Shadow public abstract void worldSelected(boolean active);

    protected SelectWorldScreenMixin(Text title) {
        super(title);
    }

    /**
     * @author
     */
    @Overwrite
    public void init() {
        this.client.keyboard.setRepeatEvents(true);
        this.searchBox = new TextFieldWidget(this.textRenderer, this.width / 2 - 100, 22, 200, 20, this.searchBox, new TranslatableText("selectWorld.search"));
        this.searchBox.setChangedListener((string) -> {
            this.levelList.filter(() -> {
                return string;
            }, false);
        });
        this.levelList = new WorldListWidget((SelectWorldScreen) (Object)this, this.client, this.width, this.height, 48, this.height - 64, 36, () -> {
            return this.searchBox.getText();
        }, this.levelList);
        this.children.add(this.searchBox);
        this.children.add(this.levelList);
        this.selectButton = (ButtonWidget)this.addButton(new ButtonWidget(this.width / 2 - 154, this.height - 52, 150, 20, new TranslatableText("selectWorld.select"), (buttonWidget) -> {
            this.levelList.method_20159().ifPresent(WorldListWidget.Entry::play);
        }));
        this.addButton(new ButtonWidget(this.width / 2 + 4, this.height - 52, 150, 20, new TranslatableText("selectWorld.create"), (buttonWidget) -> {
            this.client.openScreen(CreateWorldScreen.method_31130(this));
            BlockShuffleMod.randomize();
        }));
        this.editButton = (ButtonWidget)this.addButton(new ButtonWidget(this.width / 2 - 154, this.height - 28, 72, 20, new TranslatableText("selectWorld.edit"), (buttonWidget) -> {
            this.levelList.method_20159().ifPresent(WorldListWidget.Entry::edit);
        }));
        this.deleteButton = (ButtonWidget)this.addButton(new ButtonWidget(this.width / 2 - 76, this.height - 28, 72, 20, new TranslatableText("selectWorld.delete"), (buttonWidget) -> {
            this.levelList.method_20159().ifPresent(WorldListWidget.Entry::delete);
        }));
        this.recreateButton = (ButtonWidget)this.addButton(new ButtonWidget(this.width / 2 + 4, this.height - 28, 72, 20, new TranslatableText("selectWorld.recreate"), (buttonWidget) -> {
            this.levelList.method_20159().ifPresent(WorldListWidget.Entry::recreate);
        }));
        this.addButton(new ButtonWidget(this.width / 2 + 82, this.height - 28, 72, 20, ScreenTexts.CANCEL, (buttonWidget) -> {
            this.client.openScreen(this.parent);
        }));
        this.worldSelected(false);
        this.setInitialFocus(this.searchBox);
    }

}
