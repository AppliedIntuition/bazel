// Copyright 2014 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.syntax;

import java.io.IOException;
import javax.annotation.Nullable;

/** A wrapper Statement class for return expressions. */
public final class ReturnStatement extends Statement {

  @Nullable private final Expression returnExpression;

  ReturnStatement(@Nullable Expression returnExpression) {
    this.returnExpression = returnExpression;
  }

  @Nullable
  public Expression getReturnExpression() {
    return returnExpression;
  }

  @Override
  public void prettyPrint(Appendable buffer, int indentLevel) throws IOException {
    printIndent(buffer, indentLevel);
    buffer.append("return");
    if (returnExpression != null) {
      buffer.append(' ');
      returnExpression.prettyPrint(buffer, indentLevel);
    }
    buffer.append('\n');
  }

  @Override
  public void accept(NodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public Kind kind() {
    return Kind.RETURN;
  }
}
