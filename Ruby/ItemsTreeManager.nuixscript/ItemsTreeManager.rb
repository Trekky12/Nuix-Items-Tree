script_directory = File.dirname(__FILE__)
require File.join(script_directory,"NuixItemsTree.jar")

java_import 'gui.NuixItemsTree'


t = NuixItemsTree.new($current_case, $utilities)
t.setVisible(true)

