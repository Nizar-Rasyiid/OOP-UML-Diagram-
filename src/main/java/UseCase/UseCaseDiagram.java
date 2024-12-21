// File: UseCaseDiagram.java
package UseCase;

import java.util.*;

public class UseCaseDiagram {
    private String name;
    private List<Actor> actors;
    private List<UseCase> useCases;
    private List<Relationship> relationships;

    public UseCaseDiagram(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.useCases = new ArrayList<>();
        this.relationships = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public void addUseCase(UseCase useCase) {
        useCases.add(useCase);
    }

    public void addRelationship(Actor actor, UseCase useCase, String type) {
        relationships.add(new Relationship(actor, useCase, type));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Calculate dimensions
        int maxActorWidth = actors.stream()
                .mapToInt(a -> a.getName().length())
                .max()
                .orElse(10);
        int maxUseCaseWidth = useCases.stream()
                .mapToInt(uc -> uc.getName().length())
                .max()
                .orElse(15);
        int totalWidth = maxActorWidth + maxUseCaseWidth + 40;

        // Draw title
        String title = "«" + name + "»";
        sb.append(centerText(title, totalWidth)).append("\n");

        // Draw system boundary
        sb.append("    ┌").append("─".repeat(totalWidth - 8)).append("┐\n");

        // Draw content
        drawDiagramContent(sb, maxActorWidth, maxUseCaseWidth, totalWidth);

        // Draw bottom boundary
        sb.append("    └").append("─".repeat(totalWidth - 8)).append("┘\n");

        return sb.toString();
    }

    private void drawDiagramContent(StringBuilder sb, int maxActorWidth, int maxUseCaseWidth, int totalWidth) {
        int height = Math.max(actors.size() * 6, useCases.size() * 3);
        int actorIndex = 0;
        int useCaseIndex = 0;

        for (int i = 0; i < height; i++) {
            sb.append("    │ ");

            // Draw actors
            if (actorIndex < actors.size()) {
                if (i % 6 == 0) {
                    drawActorHead(sb, maxActorWidth, actorIndex);
                } else if (i % 6 == 1) {
                    drawActorBody(sb, maxActorWidth);
                } else if (i % 6 == 2) {
                    drawActorLegs(sb, maxActorWidth);
                } else if (i % 6 == 3) {
                    drawActorName(sb, actors.get(actorIndex).getName(), maxActorWidth);
                    actorIndex++;
                } else {
                    drawBlankLine(sb, maxActorWidth);
                }
            } else {
                drawBlankLine(sb, maxActorWidth);
            }

            // Draw connections and use cases
            if (i % 3 == 0 && useCaseIndex < useCases.size()) {
                drawConnection(sb);
                drawUseCase(sb, useCases.get(useCaseIndex).getName(), maxUseCaseWidth);
                useCaseIndex++;
            } else {
                drawBlankConnection(sb);
                drawBlankUseCase(sb, maxUseCaseWidth);
            }

            sb.append(" │\n");
        }
    }

    private void drawActorHead(StringBuilder sb, int width, int index) {
        sb.append(String.format("%-" + width + "s", "     o     "));
    }

    private void drawActorBody(StringBuilder sb, int width) {
        sb.append(String.format("%-" + width + "s", "    /|\\    "));
    }

    private void drawActorLegs(StringBuilder sb, int width) {
        sb.append(String.format("%-" + width + "s", "    / \\    "));
    }

    private void drawActorName(StringBuilder sb, String name, int width) {
        sb.append(centerText(name, width));
    }

    private void drawBlankLine(StringBuilder sb, int width) {
        sb.append(" ".repeat(width));
    }

    private void drawConnection(StringBuilder sb) {
        sb.append(" ──────► ");
    }

    private void drawBlankConnection(StringBuilder sb) {
        sb.append("         ");
    }

    private void drawUseCase(StringBuilder sb, String name, int width) {
        String useCase = "(" + name + ")";
        sb.append(centerText(useCase, width));
    }

    private void drawBlankUseCase(StringBuilder sb, int width) {
        sb.append(" ".repeat(width));
    }

    private String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        return " ".repeat(padding) + text + " ".repeat(width - text.length() - padding);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public List<UseCase> getUseCases() {
        return useCases;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }
}