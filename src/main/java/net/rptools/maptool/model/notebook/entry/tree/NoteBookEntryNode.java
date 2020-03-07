package net.rptools.maptool.model.notebook.entry.tree;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import net.rptools.maptool.model.notebook.entry.DirectoryEntry;
import net.rptools.maptool.model.notebook.entry.NoteBookEntry;

public class NoteBookEntryNode {

  private final NoteBookEntry entry;

  private final Set<NoteBookEntryNode> children = new HashSet<>();


  public NoteBookEntryNode(NoteBookEntry entry) {
    this.entry = Objects.requireNonNull(entry, "Entry for NoteBookEntryNode cannot be null");
  }

  public void addChild(NoteBookEntryNode child) {
    if (!isDirectory()) {
      throw new IllegalStateException("Cannot add a child to a non directory NoteBookEntryNode");
    }
    Objects.requireNonNull(child, "Child to add to NoteBookEntryNode cannot be null");
    children.add(child);
  }

  public Set<NoteBookEntryNode> getChildren() {
    return new HashSet<>(children);
  }

  public void removeChild(NoteBookEntryNode child) {
    Objects.requireNonNull(child, "Child to remove from NoteBookEntryNode cannot be null");
    children.remove(child);
  }

  public boolean isDirectory() {
    return entry.getClass().equals(DirectoryEntry.class);
  }

  public NoteBookEntry getEntry() {
    return entry;
  }

}
