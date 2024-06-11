import { ReactElement, JSXElementConstructor } from "react";
import { ReactAdapterElement, RenderHooks } from "./generated/flow/ReactAdapter";
import { Button, VerticalLayout } from "@vaadin/react-components";

class MyView extends ReactAdapterElement {
    protected render(hooks: RenderHooks): ReactElement {
        const toggle = hooks.useCustomEvent("toggle");
        const grid = this.useContent("grid");
        const [count] = hooks.useState<number>("count");

        return <VerticalLayout theme="padding">
            <Button onClick={toggle}>Toggle filter</Button>
            {grid}
            Row count: {count}
        </VerticalLayout>
    }
}

customElements.define("my-view", MyView);