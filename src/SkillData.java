import org.powerbot.game.api.methods.Tabs;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.wrappers.widget.WidgetChild;

public class SkillData {
	private static int widget;

	public static int getRemainderExperience(final int index) {
		setWidget(index);
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild skill = Widgets.get(WidgetInfo.WIDGET, widget);
			Mouse.move(skill.getCentralPoint());
			String contents = skills.getChild(
					WidgetInfo.WIDGET_POPUP_REMAINDER_XP).getText();
			return parseExperience(contents);
		}
		return -1;
	}

	public static int getExperience(final int index) {
		setWidget(index);
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild skill = Widgets.get(WidgetInfo.WIDGET, widget);
			Mouse.move(skill.getCentralPoint());
			String contents = skills.getChild(
					WidgetInfo.WIDGET_POPUP_CURRENT_XP).getText();
			return parseExperience(contents);
		}
		return -1;
	}

	public static int getTotalExperience() {
		setWidget(SkillIndices.TOTAL_LEVEL);
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild skill = Widgets.get(WidgetInfo.WIDGET, widget);
			Mouse.move(skill.getCentralPoint());
			String contents = skills.getChild(WidgetInfo.WIDGET_POPUP_LEVEL)
					.getText();
			return parseTotalExperience(contents);
		}
		return -1;
	}

	public static int getTotalLevel() {
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild level = Widgets.get(WidgetInfo.WIDGET,
					WidgetInfo.WIDGET_TOTAL_LEVEL);
			String contents = level.getText();
			return parseTotalLevel(contents);
		}
		return -1;
	}

	public static int getRealLevel(final int index) {
		setWidget(index);
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild skill = Widgets.get(WidgetInfo.WIDGET, widget);
			Mouse.move(skill.getCentralPoint());
			String contents = skills.getChild(WidgetInfo.WIDGET_POPUP_LEVEL)
					.getText();
			return parseRealLevel(contents);
		}
		return -1;
	}

	public static int getLevel(final int index) {
		setWidget(index);
		if (!(Tabs.getCurrent() == Tabs.STATS)) {
			Tabs.STATS.open();
		}
		final WidgetChild skills = Widgets.get(WidgetInfo.WIDGET,
				WidgetInfo.WIDGET_POPUP);
		if (isWidgetChildVisible(skills)) {
			final WidgetChild skill = Widgets.get(WidgetInfo.WIDGET, widget);
			Mouse.move(skill.getCentralPoint());
			String contents = skills.getChild(WidgetInfo.WIDGET_POPUP_LEVEL)
					.getText();
			return parseLevel(contents);
		}
		return -1;
	}

	private static int parseExperience(final String s) {
		String xp;
		if (s.length() > 0) {
			xp = s;
			if (xp.contains(",")) {
				xp = xp.replace(",", "");
			}
			return Integer.parseInt(xp);
		}
		return -1;
	}

	private static int parseTotalExperience(final String s) {
		String xp;
		if (s.contains("XP: ")) {
			xp = s.substring(s.indexOf(": ") + 2);
			if (xp.contains(",")) {
				xp = xp.replace(",", "");
			}
			return Integer.parseInt(xp);
		}
		return -1;
	}

	private static int parseTotalLevel(final String s) {
		String level;
		if (s.contains("el: ")) {
			level = s.substring(s.indexOf(": ") + 2);
			return Integer.parseInt(level);
		}
		return -1;
	}

	private static int parseRealLevel(final String s) {
		String level;
		if (s.contains(": ") && s.contains("/")) {
			level = s.substring(s.indexOf("/") + 1);
			return Integer.parseInt(level);
		} else if (s.contains("embe")) {
			return -1;
		}
		return -1;
	}

	private static int parseLevel(final String s) {
		String level;
		if (s.contains(": ") && s.contains("/")) {
			level = s.substring(s.indexOf(": ") + 2, s.indexOf("/"));
			return Integer.parseInt(level);
		} else if (s.contains("embe")) {
			return -1;
		}
		return -1;
	}

	private static boolean isWidgetChildVisible(final WidgetChild wc) {
		return wc != null && wc.validate() && wc.visible() && wc.isOnScreen();
	}

	private static void setWidget(final int index) {
		switch (index) {
		case 0:
			widget = WidgetInfo.WIDGET_ATTACK;
			break;
		case 1:
			widget = WidgetInfo.WIDGET_DEFENSE;
			break;
		case 2:
			widget = WidgetInfo.WIDGET_STRENGTH;
			break;
		case 3:
			widget = WidgetInfo.WIDGET_CONSTITUTION;
			break;
		case 4:
			widget = WidgetInfo.WIDGET_RANGE;
			break;
		case 5:
			widget = WidgetInfo.WIDGET_PRAYER;
			break;
		case 6:
			widget = WidgetInfo.WIDGET_MAGIC;
			break;
		case 7:
			widget = WidgetInfo.WIDGET_COOKING;
			break;
		case 8:
			widget = WidgetInfo.WIDGET_WOODCUTTING;
			break;
		case 9:
			widget = WidgetInfo.WIDGET_FLETCHING;
			break;
		case 10:
			widget = WidgetInfo.WIDGET_FISHING;
			break;
		case 11:
			widget = WidgetInfo.WIDGET_FIREMAKING;
			break;
		case 12:
			widget = WidgetInfo.WIDGET_CRAFTING;
			break;
		case 13:
			widget = WidgetInfo.WIDGET_SMITHING;
			break;
		case 14:
			widget = WidgetInfo.WIDGET_MINING;
			break;
		case 15:
			widget = WidgetInfo.WIDGET_HERBLORE;
			break;
		case 16:
			widget = WidgetInfo.WIDGET_AGILITY;
			break;
		case 17:
			widget = WidgetInfo.WIDGET_THIEVING;
			break;
		case 18:
			widget = WidgetInfo.WIDGET_SLAYER;
			break;
		case 19:
			widget = WidgetInfo.WIDGET_FARMING;
			break;
		case 20:
			widget = WidgetInfo.WIDGET_RUNECRAFTING;
			break;
		case 21:
			widget = WidgetInfo.WIDGET_HUNTER;
			break;
		case 22:
			widget = WidgetInfo.WIDGET_CONSTRUCTION;
			break;
		case 23:
			widget = WidgetInfo.WIDGET_SUMMONING;
			break;
		case 24:
			widget = WidgetInfo.WIDGET_DUNGEONEERING;
			break;
		case 25:
			widget = WidgetInfo.WIDGET_TOTAL_LEVEL;
			break;
		default:
			break;
		}
	}
}
